package com.hitta.android.assignment.data.source

import android.util.Log
import com.hitta.android.assignment.data.Review
import com.hitta.android.assignment.data.source.ReviewsDataSource.GetCompanyListener
import com.hitta.android.assignment.data.source.ReviewsDataSource.GetReviewListener
import com.hitta.android.assignment.data.source.local.ReviewsLocalDataSource
import com.hitta.android.assignment.data.source.remote.ReviewsRemoteDataSource

/**
 * Implementation to load reviews related dependencies into a cache
 */

class ReviewsRepository private constructor(private val localDataSource: ReviewsLocalDataSource, private val remoteDataSource: ReviewsRemoteDataSource) : ReviewsDataSource {

    private var cachedCompanyName: String? = null

    private var cachedReview: Review? = null

    override fun getReviewById(id: Int, listener: GetReviewListener) {
        Log.d(TAG, "getReviewById")
        if (cachedReview != null) {
            Log.d(TAG, "getReviewById - from cache")
            listener.onReviewLoadCompleted(cachedReview!!)
            return
        }
        localDataSource.getReviewById(id, object : GetReviewListener {
            override fun onReviewLoadCompleted(review: Review) {
                Log.d(TAG, "localDataSource - getReviewById - onReviewLoadCompleted")
                refreshCachedDataReview(review)
                listener.onReviewLoadCompleted(review)
            }

            override fun onNoDataAvailable() {
                Log.d(TAG, "localDataSource - getReviewById - onNoDataAvailable")
                listener.onNoDataAvailable()
            }
        })
    }

    override fun getCompanyName(listener: GetCompanyListener) {
        Log.d(TAG, "getCompanyName")
        if (!cachedCompanyName.isNullOrEmpty()) {
            Log.d(TAG, "getCompanyName - from cache")
            listener.onReviewLoadCompleted(cachedCompanyName!!)
            return
        }
        localDataSource.getCompanyName(object : GetCompanyListener {
            override fun onReviewLoadCompleted(name: String) {
                Log.d(TAG, "localDataSource - getCompanyName - onReviewLoadCompleted")
                refreshCachedCompanyName(name)
                listener.onReviewLoadCompleted(name)
            }

            override fun onNoDataAvailable() {
                Log.d(TAG, "localDataSource - getCompanyName - onNoDataAvailable")
                getCompanyNameFromRemoteDataSource(listener)
            }
        })
    }

    override fun saveReview(review: Review) {
        Log.d(TAG, "saveReview")
        refreshCachedDataReview(review)
        localDataSource.saveReview(review)
        remoteDataSource.saveReview(review)
    }

    private fun getCompanyNameFromRemoteDataSource(listener: GetCompanyListener) {
        Log.d(TAG, "getCompanyNameFromRemoteDataSource")
        remoteDataSource.getCompanyName(object : GetCompanyListener {
            override fun onReviewLoadCompleted(name: String) {
                Log.d(TAG, "remoteDataSource - getCompanyName - onReviewLoadCompleted")
                refreshCachedCompanyName(name)
                listener.onReviewLoadCompleted(name)
            }

            override fun onNoDataAvailable() {
                Log.d(TAG, "remoteDataSource - getCompanyName - onNoDataAvailable")
                listener.onNoDataAvailable()
            }
        })
    }

    private fun refreshCachedDataReview(review: Review) {
        Log.d(TAG, "refreshCachedDataReview")
        cachedReview = review.apply { if (!cachedCompanyName.isNullOrEmpty()) companyName = cachedCompanyName }
    }

    private fun refreshCachedCompanyName(name: String) {
        Log.d(TAG, "refreshCachedCompanyName")
        cachedCompanyName = name
    }

    companion object {

        private var TAG = ReviewsRepository::class.java.simpleName

        @Volatile
        private var instance: ReviewsRepository? = null

        fun getInstance(localDataSource: ReviewsLocalDataSource, remoteDataSource: ReviewsRemoteDataSource): ReviewsRepository =
                instance ?: synchronized(ReviewsRepository::class.java) {
                    instance ?: ReviewsRepository(localDataSource, remoteDataSource).apply { instance = this }
                }
    }
}
package com.hitta.android.assignment.data.source.local

import android.util.Log
import com.hitta.android.assignment.data.Review
import com.hitta.android.assignment.data.source.ReviewsDataSource
import com.hitta.android.assignment.data.source.ReviewsDataSource.GetCompanyListener
import com.hitta.android.assignment.data.source.ReviewsDataSource.GetReviewListener
import com.hitta.android.assignment.utils.AppExecutors
import com.hitta.android.assignment.utils.Constants

/**
 * Implementation of data source as a database
 */
class ReviewsLocalDataSource private constructor(private val appExecutors: AppExecutors, private val reviewsDao: ReviewsDao) : ReviewsDataSource {

    override fun getReviewById(id: Int, listener: GetReviewListener) {
        Log.d(TAG, "getReviewById")
        appExecutors.diskIO().execute {
            val review = reviewsDao.getReviewById(id)
            appExecutors.mainThread().execute {
                if (review != null) {
                    listener.onReviewLoadCompleted(review)
                } else {
                    listener.onNoDataAvailable()
                }
            }
        }
    }

    override fun saveReview(review: Review) {
        Log.d(TAG, "saveReview")
        appExecutors.diskIO().execute {
            reviewsDao.insertReview(review)
        }
    }

    override fun getCompanyName(listener: GetCompanyListener) {
        Log.d(TAG, "getCompanyName")
        appExecutors.diskIO().execute {
            val review = reviewsDao.getReviewById(Constants.MOCK_DATABASE_REVIEW_ID)
            appExecutors.mainThread().execute {
                if (review?.companyName != null) {
                    listener.onReviewLoadCompleted(review.companyName!!)
                } else {
                    listener.onNoDataAvailable()
                }
            }
        }
    }

    companion object {

        private var TAG = ReviewsLocalDataSource::class.java.simpleName

        @Volatile
        private var instance: ReviewsLocalDataSource? = null

        fun getInstance(appExecutors: AppExecutors, reviewsDao: ReviewsDao): ReviewsLocalDataSource =
                instance ?: synchronized(ReviewsLocalDataSource::class.java) {
                    instance ?: ReviewsLocalDataSource(appExecutors, reviewsDao).apply { instance = this }
                }
    }

}
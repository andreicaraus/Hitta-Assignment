package com.hitta.android.assignment.data.source

import com.hitta.android.assignment.data.Review

/**
 * Entry point to access review data
 */
interface ReviewsDataSource {

    fun getReviewById(id: Int, listener: GetReviewListener)

    fun getCompanyName(listener: GetCompanyListener)

    fun saveReview(review: Review)

    interface GetReviewListener {

        fun onReviewLoadCompleted(review: Review)

        fun onNoDataAvailable()
    }

    interface GetCompanyListener {

        fun onReviewLoadCompleted(name: String)

        fun onNoDataAvailable()
    }
}
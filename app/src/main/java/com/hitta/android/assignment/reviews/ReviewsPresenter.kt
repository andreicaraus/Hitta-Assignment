package com.hitta.android.assignment.reviews

import com.hitta.android.assignment.R
import com.hitta.android.assignment.data.Review
import com.hitta.android.assignment.data.source.ReviewsDataSource
import com.hitta.android.assignment.data.source.ReviewsRepository
import com.hitta.android.assignment.utils.Constants
import com.hitta.android.assignment.utils.ConversionUtils

class ReviewsPresenter(private val reviewRepository: ReviewsRepository, private val view: ReviewsContract.View) : ReviewsContract.Presenter {

    private var companyName: String? = null

    init {
        view.setPresenter(this)
    }

    override fun start() {
        view.setTopBarTitle(view.getResources().getString(R.string.app_name))
        reviewRepository.getCompanyName(object : ReviewsDataSource.GetCompanyListener {
            override fun onReviewLoadCompleted(name: String) {
                companyName = name
                if (!view.isActive())
                    return
                view.setCompanyName(view.getResources().getString(R.string.reviews_with_company_name, companyName))
            }

            override fun onNoDataAvailable() {
                //no implementation currently
            }

        })
        reviewRepository.getReviewById(Constants.MOCK_DATABASE_REVIEW_ID, object : ReviewsDataSource.GetReviewListener {
            override fun onReviewLoadCompleted(review: Review) {
                handleReviewLoadCompleted(review)
            }

            override fun onNoDataAvailable() {
                //no implementation currently
            }
        })
    }

    override fun onDescribeExperienceTextClicked() {
        view.startAddEditFragment(true)
    }

    override fun onRatingChanged(rating: Float, fromUser: Boolean) {
        if (fromUser) {
            reviewRepository.saveReview(Review(Constants.MOCK_DATABASE_REVIEW_ID, companyName, rating, "", "", System.currentTimeMillis()))
            view.startAddEditFragment(false)
        }
    }

    private fun handleReviewLoadCompleted(review: Review) {
        if (!view.isActive())
            return
        val score = review.rateScore
        val name = review.reviewerName
        val comment = review.comment
        val timestamp = review.timestamp

        view.setSmallRatingBarValue(score)
        if (!name.isNullOrEmpty()) {
            view.setName(name)
        } else {
            view.setName(view.getResources().getString(R.string.anonymous))
        }

        if (!comment.isNullOrEmpty()) {
            view.setComment(comment)
            view.showCommentText()
        } else {
            view.showReviewerAddComment()
        }

        view.setReviewerTimestamp(ConversionUtils.getDurationStringFromTimestamp(view.getResources(), timestamp))

        view.showDots()
        view.showReviewerHeader()
        view.hideBigRatingBar()
        view.showSmallRatingBar()
    }

}
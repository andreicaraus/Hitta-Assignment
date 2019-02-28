package com.hitta.android.assignment.addeditreview

import com.hitta.android.assignment.R
import com.hitta.android.assignment.common.dialog.DialogButtonListener
import com.hitta.android.assignment.data.Review
import com.hitta.android.assignment.data.source.ReviewsDataSource
import com.hitta.android.assignment.data.source.ReviewsRepository
import com.hitta.android.assignment.utils.Constants

/**
 * Listens for user actions from the AddEditReviewFragment, retrieves the data and updates the UI
 */
class AddEditReviewPresenter(private val reviewRepository: ReviewsRepository, private val view: AddEditReviewContract.View) : AddEditReviewContract.Presenter, DialogButtonListener {

    private var ratingScore: Float? = null

    private var companyNameString: String? = null

    private var initialName: String? = null

    private var initialComment: String? = null

    private var initialRatingScore: Float? = null

    init {
        view.setPresenter(this)
    }

    override fun start(focusOnComment: Boolean) {
        reviewRepository.getCompanyName(object : ReviewsDataSource.GetCompanyListener {
            override fun onReviewLoadCompleted(name: String) {
                companyNameString = name
                if (!view.isActive())
                    return
                view.setTopBarTitle(view.getResources().getString(R.string.review_with_company_name, name))
            }

            override fun onNoDataAvailable() {
                //no implementation currently
            }

        })
        reviewRepository.getReviewById(Constants.MOCK_DATABASE_REVIEW_ID, object : ReviewsDataSource.GetReviewListener {
            override fun onReviewLoadCompleted(review: Review) {
                if (!view.isActive())
                    return
                ratingScore = review.rateScore
                initialRatingScore = review.rateScore

                view.setRatingBarValue(ratingScore!!)
                handleNewRatingValue()

                val reviewerName = review.reviewerName
                initialName = reviewerName
                if (!reviewerName.isNullOrEmpty())
                    view.setReviewerName(reviewerName)

                val reviewerComment = review.comment
                initialComment = reviewerComment
                if (!reviewerComment.isNullOrEmpty())
                    view.setReviewerComment(reviewerComment)
            }

            override fun onNoDataAvailable() {
                //no implementation currently
            }
        })
        if (focusOnComment) {
            view.showKeyboardForComment()
        } else {
            view.showKeyboardForName()
        }
    }

    override fun onRatingChanged(rating: Float, fromUser: Boolean) {
        ratingScore = rating
        if (fromUser) {
            if (ratingScore!! < MINIMUM_RATING_VALUE)
                view.setRatingBarValue(MINIMUM_RATING_VALUE)
            handleNewRatingValue()
        }
    }

    override fun onBackPressed() {
        view.hideKeyboard()
        updateRating()
    }

    override fun onSaveButtonPressed() {
        saveData()
        view.hideKeyboard()
        view.showDialog(view.getResources().getString(R.string.dialog_title),
                view.getResources().getString(R.string.dialog_message),
                view.getResources().getString(R.string.dialog_button),
                this)
    }

    override fun onPositiveButtonPressed() {
        view.goToReviewsScreen()
    }

    private fun saveData() {
        val name = view.getNameText()
        val comment = view.getCommentText()
        if (initialComment != comment || initialName != name || initialRatingScore != ratingScore) {
            reviewRepository.saveReview(Review(Constants.MOCK_DATABASE_REVIEW_ID, companyNameString, ratingScore!!, name, comment, System.currentTimeMillis()))
        }
    }

    private fun updateRating() {
        if (initialRatingScore != ratingScore) {
            reviewRepository.saveReview(Review(Constants.MOCK_DATABASE_REVIEW_ID, companyNameString, ratingScore!!, initialName, initialComment, System.currentTimeMillis()))
        }
    }

    private fun handleNewRatingValue() {
        val ratingText = when (ratingScore) {
            1f -> R.string.rate_score_1
            2f -> R.string.rate_score_2
            3f -> R.string.rate_score_3
            4f -> R.string.rate_score_4
            else -> R.string.rate_score_5
        }
        view.setRatingText(view.getResources().getString(ratingText))
    }

    companion object {
        private const val MINIMUM_RATING_VALUE = 1f
    }
}
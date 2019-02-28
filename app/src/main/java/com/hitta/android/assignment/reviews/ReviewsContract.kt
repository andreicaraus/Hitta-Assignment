package com.hitta.android.assignment.reviews

import com.hitta.android.assignment.common.BaseView

interface ReviewsContract {

    interface Presenter {

        fun start()

        fun onDescribeExperienceTextClicked()

        fun onRatingChanged(rating: Float, fromUser: Boolean)
    }

    interface View : BaseView<Presenter> {

        fun setSmallRatingBarValue(rate: Float)

        fun setName(name: String)

        fun setComment(comment: String)

        fun hideBigRatingBar()

        fun showSmallRatingBar()

        fun showReviewerHeader()

        fun showReviewerAddComment()

        fun showCommentText()

        fun showDots()

        fun setCompanyName(companyName: String)

        fun setReviewerTimestamp(timestamp: String)

        fun startAddEditFragment(focusOnComment: Boolean)
    }
}
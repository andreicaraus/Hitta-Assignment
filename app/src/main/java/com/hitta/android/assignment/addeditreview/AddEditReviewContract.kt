package com.hitta.android.assignment.addeditreview

import com.hitta.android.assignment.common.BaseView
import com.hitta.android.assignment.common.dialog.DialogButtonListener

interface AddEditReviewContract {

    interface Presenter {

        fun start(focusOnComment: Boolean)

        fun onRatingChanged(rating: Float, fromUser: Boolean)

        fun onBackPressed()

        fun onSaveButtonPressed()
    }

    interface View : BaseView<Presenter> {

        fun setReviewerName(name: String)

        fun setReviewerComment(comment: String)

        fun setRatingText(rateText: String)

        fun setRatingBarValue(rate: Float)

        fun showDialog(title: String, message: String, button: String, listener: DialogButtonListener)

        fun getCommentText(): String

        fun getNameText(): String

        fun goToReviewsScreen()

        fun showKeyboardForName()

        fun showKeyboardForComment()

        fun hideKeyboard()
    }
}
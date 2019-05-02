package com.hitta.android.assignment.main.util.util

import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.pressBack
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKCOMMENTSHORT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKNAMESHORT
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsDetails
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class Back {

    companion object {

        fun doNothingBack() {
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun nameBack() {
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun commentBack() {
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat() ) }
        }

        fun starBack() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun nameCommentBack() {
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun starNameBack() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun starCommentBack() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun starNameCommentBack() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            closeSoftKeyboard()
            pressBack()
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }
    }
}
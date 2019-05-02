package com.hitta.android.assignment.main.util.util

import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKCOMMENTSHORT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKNAMESHORT
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsDetails
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class Navigate {

    companion object {
        fun doNothingUp() {
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun nameUp() {
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun commentUp() {
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat() ) }
        }

        fun starUp() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun nameCommentUp() {
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun starNameUp() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun starCommentUp() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun starNameCommentUp() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().nameEdit { typeText(MOCKNAMESHORT) }
            ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
            ReviewDetails().navigateUp { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }
    }
}
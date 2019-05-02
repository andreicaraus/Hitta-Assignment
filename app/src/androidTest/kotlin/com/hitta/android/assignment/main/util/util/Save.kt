package com.hitta.android.assignment.main.util.util

import com.hitta.android.assignment.main.screens.ReviewConfirmation
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKCOMMENTLONG
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKNAMELONG
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsDetails
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class Save {

    companion object {
        fun doNothingSave() {
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun nameSave() {
            ReviewDetails().nameEdit { clearText(); typeText(MOCKNAMELONG) }
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun commentSave() {
            ReviewDetails().commentEdit { clearText(); typeText(MOCKCOMMENTLONG) }
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat() ) }
        }

        fun starSave() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun nameCommentSave() {
            ReviewDetails().nameEdit { clearText(); typeText(MOCKNAMELONG) }
            ReviewDetails().commentEdit { clearText(); typeText(MOCKCOMMENTLONG) }
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsMain.toFloat()) }
        }

        fun starNameSave() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().nameEdit { clearText(); typeText(MOCKNAMELONG) }
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun starCommentSave() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().commentEdit { clearText(); typeText(MOCKCOMMENTLONG) }
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }

        fun starNameCommentSave() {
            UtilReviewDetails.reviewDetailsRatingBar.perform(SetRating.setRating(starsDetails))
            ReviewDetails().nameEdit { clearText(); typeText(MOCKNAMELONG) }
            ReviewDetails().commentEdit { clearText(); typeText(MOCKCOMMENTLONG) }
            ReviewDetails().save { click() }
            ReviewConfirmation().alertYes { click() }
            ReviewsMain().smallRatingBar { hasRating(starsDetails.toFloat() ) }
        }
    }
}
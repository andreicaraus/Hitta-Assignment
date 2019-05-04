package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.util.SetRating.Companion.setRating
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.reviewsMainBigRatingBar
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

@LargeTest
@RunWith(AndroidJUnit4::class)

class FieldFocus {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)


    /**************
     * DESCRIPTION:
     * Checks if the focus in the Review Details screen is correct in the edit fields, related to the corresponding flow (on the name when rating the first time, on comment, when coming from the Describe button)
     */

    @Test
    fun fieldFocus() {
        reviewsMainBigRatingBar.perform(setRating(starsMain))
        ReviewDetails().nameEdit { isFocused() }
        ReviewDetails().navigateUp { click() }
        ReviewsMain().yourReviewDescribe { click() }
        ReviewDetails().commentEdit { isFocused() }
    }
}
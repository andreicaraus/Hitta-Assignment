package com.hitta.android.assignment.main.tests.ui

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.COMMENTHINT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.NAMEHINT
import com.hitta.android.assignment.main.util.util.SetRating.Companion.setRating
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.isNotVisible
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.isVisible
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain
import com.hitta.android.assignment.main.util.util.UtilReviewDetails.Companion.reviewDetailsRatingBar
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.reviewsMainBigRatingBar
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class ReviewDetailsScreen {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)

    @Before
    fun runBefore() {
        reviewsMainBigRatingBar.perform(setRating(starsMain))
    }


    /**************
     * DESCRIPTION:
     * Checks that the UI elements from the Reviews Input/ Details Screen that should be visible for the user are displayed and match the specifications
     */

    @Test
    fun uiReviewDetailsScreen() {
        ReviewDetails().navigateUp { isDisplayed() }
        ReviewDetails().reviewShopName { isDisplayed() }
        ReviewDetails().save { isDisplayed() }
        ReviewDetails().ratingBar { isDisplayed() }
        ReviewDetails().starSeparator { isDisplayed() }
        ReviewDetails().nameEdit { isDisplayed() }
        ReviewDetails().nameSeparator { isDisplayed() }
        ReviewDetails().commentEdit { isDisplayed() }
        ReviewDetails().commentSeparator { isDisplayed() }
    }


    /**************
     * DESCRIPTION:
     * Checks that the placeholders for the 2 fields are visible when acessing the screen for the first time or after deleting the text and not visible when a text is written
     */

    @Test
    fun placeHolder() {
        isVisible(NAMEHINT)
        isVisible(COMMENTHINT)

        ReviewDetails().nameEdit { typeText(" ") }
        ReviewDetails().commentEdit { typeText(" ") }

        isNotVisible(NAMEHINT)
        isNotVisible(COMMENTHINT)

        ReviewDetails().nameEdit { clearText() }
        ReviewDetails().commentEdit { clearText() }

        isVisible(NAMEHINT)
        isVisible(COMMENTHINT)
    }


    /**************
     * DESCRIPTION:
     * Checks that the correct text is displayed when selecting each star
     */

    @Test
    fun starsTexts() {
        reviewDetailsRatingBar.perform(setRating(1))
        ReviewDetails().star1Text { isDisplayed() }

        reviewDetailsRatingBar.perform(setRating(2))
        ReviewDetails().star2Text { isDisplayed() }

        reviewDetailsRatingBar.perform(setRating(3))
        ReviewDetails().star3Text { isDisplayed() }

        reviewDetailsRatingBar.perform(setRating(4))
        ReviewDetails().star4Text { isDisplayed() }

        reviewDetailsRatingBar.perform(setRating(5))
        ReviewDetails().star5Text { isDisplayed() }
    }
}
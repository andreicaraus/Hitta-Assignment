package com.hitta.android.assignment.main.tests.ui

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.screens.ReviewsMain
import org.junit.Test
import org.junit.runner.RunWith
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewConfirmation
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.ANONYMOUS
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.MOCKCOMMENTSHORT
import com.hitta.android.assignment.main.util.util.NestedScrollTo.nestedScrollTo
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.reviewsMainViewReviewsBottom
import org.junit.Rule
import java.util.concurrent.TimeUnit

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class ReviewsMainScreen {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)


    /**************
     * DESCRIPTION:
     * Checks that the UI elements from the Main Screen, in the state when no rating is submitted, that should be visible for the user, are displayed and match the specifications and that the elements from state 2 and 3 are not visible
     */

    @Test
    fun uiReviewsMainScreenNoRating(){
        ReviewsMain().yourReviewPhoto { isDisplayed()}
        ReviewsMain().yourReviewRate { isDisplayed()}
        ReviewsMain().yourReviewInfo { isDisplayed()}
        ReviewsMain().bigRatingBar { isDisplayed(); hasRating(0F)}
        ReviewsMain().yourReviewHeader { isNotDisplayed()}
        ReviewsMain().smallRatingBar { isNotDisplayed()}
        ReviewsMain().yourReviewDescribe { isNotDisplayed()}
        ReviewsMain().moreOptions { isNotDisplayed()}
        ReviewsMain().yourReviewComment { isNotDisplayed()}

        uiReviewsMainScreenCommon()
    }


    /**************
     * DESCRIPTION:
     * Checks that the UI elements from the Main Screen, in the state when a star rating is saved (without review), that should be visible for the user, are displayed and match the specifications and that the elements from state 1 and 3 are not visible
     */

    @Test
    fun uiReviewsMainScreenStarRating(){
        ReviewsMain().bigRatingBar { click() }
        ReviewDetails().navigateUp { click() }

        ReviewsMain().yourReviewHeader { isDisplayed()}
        ReviewsMain().yourReviewPhoto { isDisplayed()}
        ReviewsMain().yourReviewName { isDisplayed(); matches { withText(ANONYMOUS) } }
        ReviewsMain().yourReviewTime { isDisplayed() }
        ReviewsMain().smallRatingBar { isDisplayed()}
        ReviewsMain().yourReviewDescribe { isDisplayed()}
        ReviewsMain().moreOptions { isDisplayed()}
        ReviewsMain().bigRatingBar { isNotDisplayed() }
        ReviewsMain().yourReviewComment { isNotDisplayed()}

        uiReviewsMainScreenCommon()
    }


    /**************
     * DESCRIPTION:
     * Checks that the UI elements from the Main Screen, in the state when a review is saved, that should be visible for the user, are displayed and match the specifications and that the elements from state 1 and 2 are not visible
     */

    @Test
    fun uiReviewsMainScreenReview(){
        ReviewsMain().bigRatingBar { click() }
        ReviewDetails().commentEdit { typeText(MOCKCOMMENTSHORT) }
        ReviewDetails().save { click() }
        ReviewConfirmation().alertYes { click() }

        ReviewsMain().yourReviewHeader { isDisplayed()}
        ReviewsMain().yourReviewPhoto { isDisplayed()}
        ReviewsMain().yourReviewName { isDisplayed(); matches { withText(ANONYMOUS) } }
        ReviewsMain().yourReviewTime { isDisplayed() }
        ReviewsMain().smallRatingBar { isDisplayed()}
        ReviewsMain().yourReviewComment { isDisplayed(); matches { withText(MOCKCOMMENTSHORT) }}
        ReviewsMain().moreOptions { isDisplayed()}
        ReviewsMain().bigRatingBar { isNotDisplayed() }
        ReviewsMain().yourReviewDescribe { isNotDisplayed()}

        uiReviewsMainScreenCommon()
    }


    /**************
     * DESCRIPTION:
     * Checks that the UI elements from the Main Screen, common for all states of the your review section, that should be visible for the user, are displayed and match the specifications
     */

    fun uiReviewsMainScreenCommon() {
        ReviewsMain().appName { isDisplayed() }

        //Workaround for this particular text, the tests fail randomly without this timeout
        TimeUnit.MILLISECONDS.sleep(1000)
        ReviewsMain().reviewsShopName { isDisplayed() }

        ReviewsMain().averageRating { isDisplayed() }
        ReviewsMain().numberRatings { isDisplayed() }
        ReviewsMain().viewReviewsTop { isDisplayed() }
        ReviewsMain().reviewsSeparator { isDisplayed() }
        ReviewsMain().yourReviewSeparator { isDisplayed() }
        ReviewsMain().latestReviewsHeader { isDisplayed() }
        ReviewsMain().review1Photo { isDisplayed() }
        ReviewsMain().review1Name { isDisplayed() }
        ReviewsMain().review1Stars { isDisplayed() }
        ReviewsMain().review1Time { isDisplayed() }
        ReviewsMain().review1Comment { isDisplayed() }
        ReviewsMain().review1Separator { isDisplayed() }

        //Scroll to the last element in the page to prevent the test failing if run on low resolutions
        reviewsMainViewReviewsBottom.perform(nestedScrollTo())

        ReviewsMain().review2Photo { isDisplayed() }
        ReviewsMain().review2Name { isDisplayed() }
        ReviewsMain().review2Stars { isDisplayed() }
        ReviewsMain().review2Time { isDisplayed() }
        ReviewsMain().review2Comment { isDisplayed() }
        ReviewsMain().review2Separator { isDisplayed() }
        ReviewsMain().review3Photo { isDisplayed() }
        ReviewsMain().review3Name { isDisplayed() }
        ReviewsMain().review3Stars { isDisplayed() }
        ReviewsMain().review3Time { isDisplayed() }
        ReviewsMain().review3Comment { isDisplayed() }
        ReviewsMain().viewReviewsBottom { isDisplayed() }
    }
}
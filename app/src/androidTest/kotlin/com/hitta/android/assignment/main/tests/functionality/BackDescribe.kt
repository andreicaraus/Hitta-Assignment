package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.util.Back
import com.hitta.android.assignment.main.util.util.SetRating.Companion.setRating
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainAnonymousDescribe
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

class BackDescribe {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)

    @Before
    fun runBefore() {
        reviewsMainBigRatingBar.perform(setRating(starsMain))
        ReviewDetails().navigateUp { click() }
        ReviewsMain().yourReviewDescribe { click() }
    }


    /**************
     * DESCRIPTION:
     * The following tests cover all the combinations between Describe your experience button from the main screen and pressing the back button after not writing anything, writing a name or/ and comment, changing the star rating, the expected behavior being to keep or save the new stars, but nothing else, show anonymous name and the describe button in the main screen
     */

    @Test
    fun describeDoNothingBack() {
        Back.doNothingBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeNameBack() {
        Back.nameBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeCommentBack() {
        Back.commentBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeStarBack() {
        Back.starBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeNameCommentBack() {
        Back.nameCommentBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeStarNameBack() {
        Back.starNameBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeStarCommentBack() {
        Back.starCommentBack()
        mainAnonymousDescribe()
    }

    @Test
    fun describeStarNameCommentBack() {
        Back.starNameCommentBack()
        mainAnonymousDescribe()
    }
}
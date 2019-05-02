package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
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

class BackStar {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)

    @Before
    fun runBefore() {
        reviewsMainBigRatingBar.perform(setRating(starsMain))
    }


    /**************
     * DESCRIPTION:
     * The following tests cover all the combinations between star rating from the main screen and pressing the back button after not writing anything, writing a name or/ and comment, changing the star rating, the expected behavior being to always save the stars, but nothing else, show anonymous name and the describe button in the main screen
     */

    @Test
    fun starDoNothingBack() {
        Back.doNothingBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starNameBack() {
        Back.nameBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starCommentBack() {
        Back.commentBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starStarBack() {
        Back.starBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starNameCommentBack() {
        Back.nameCommentBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starStarNameBack() {
        Back.starNameBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starStarCommentBack() {
        Back.starCommentBack()
        mainAnonymousDescribe()
    }

    @Test
    fun starStarNameCommentBack() {
        Back.starNameCommentBack()
        mainAnonymousDescribe()
    }
}
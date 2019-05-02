package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.util.Save
import com.hitta.android.assignment.main.util.util.SetRating.Companion.setRating
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainAnonymousComment
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainAnonymousDescribe
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainName2Comment
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainName2Describe
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

class SaveDescribe {

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
     * The following tests cover all the combinations between Describe your experience button from the main screen and pressing save after not writing anything, writing a name or/ and comment, changing the star rating, the expected behavior being to always save everything and check that in the main screen
     */

    @Test
    fun describeDoNothingSave() {
        Save.doNothingSave()
        mainAnonymousDescribe()
    }

    @Test
    fun describeNameSave() {
        Save.nameSave()
        mainName2Describe()
    }

    @Test
    fun describeCommentSave() {
        Save.commentSave()
        mainAnonymousComment()
    }

    @Test
    fun describeStarSave() {
        Save.starSave()
        mainAnonymousDescribe()
    }

    @Test
    fun describeNameCommentSave() {
        Save.nameCommentSave()
        mainName2Comment()
    }

    @Test
    fun describeStarNameSave() {
        Save.starNameSave()
        mainName2Describe()
    }

    @Test
    fun describeStarCommentSave() {
        Save.starCommentSave()
        mainAnonymousComment()
    }

    @Test
    fun describeStarNameCommentSave() {
        Save.starNameCommentSave()
        mainName2Comment()
    }
}
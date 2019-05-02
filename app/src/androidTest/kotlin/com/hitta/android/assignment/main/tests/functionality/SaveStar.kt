package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
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

class SaveStar {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)

    @Before
    fun runBefore() {
        reviewsMainBigRatingBar.perform(setRating(starsMain))
    }


    /**************
     * DESCRIPTION:
     * The following tests cover all the combinations between star rating from the main screen and pressing save after not writing anything, writing a name or/ and comment, changing the star rating, the expected behavior being to always save everything and check that in the main screen
     */

    @Test
    fun starDoNothingSave() {
        Save.doNothingSave()
        mainAnonymousDescribe()
    }

    @Test
    fun starNameSave() {
        Save.nameSave()
        mainName2Describe()
    }

    @Test
    fun starCommentSave() {
        Save.commentSave()
        mainAnonymousComment()
    }

    @Test
    fun starStarSave() {
        Save.starSave()
        mainAnonymousDescribe()
    }

    @Test
    fun starNameCommentSave() {
        Save.nameCommentSave()
        mainName2Comment()
    }

    @Test
    fun starStarNameSave() {
        Save.starNameSave()
        mainName2Describe()
    }

    @Test
    fun starStarCommentSave() {
        Save.starCommentSave()
        mainAnonymousComment()
    }

    @Test
    fun starStarNameCommentSave() {
        Save.starNameCommentSave()
        mainName2Comment()
    }
}
package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewConfirmation
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain
import com.hitta.android.assignment.main.util.util.Save
import com.hitta.android.assignment.main.util.util.SetRating.Companion.setRating
import com.hitta.android.assignment.main.util.util.UtilCommon.Companion.starsMain
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainName2Comment
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainName2Describe
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainNameComment
import com.hitta.android.assignment.main.util.util.UtilReviewsMain.Companion.mainNameDescribe
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

class SaveNameDescribe {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)

    @Before
    fun runBefore() {
        reviewsMainBigRatingBar.perform(setRating(starsMain))
        ReviewDetails().nameEdit { typeText(MockReviewsMain.MOCKNAMESHORT) }
        ReviewDetails().save { click() }
        ReviewConfirmation().alertYes { click() }
        ReviewsMain().yourReviewDescribe { click() }
    }


    /**************
     * DESCRIPTION:
     * The following tests cover all the combinations between Describe your experience button from the main screen with a previously saved name and pressing save after not writing anything, writing a name or/ and comment, changing the star rating, the expected behavior being to always save everything and check that in the main screen
     */

    @Test
    fun nameDescribeDoNothingSave() {
        Save.doNothingSave()
        mainNameDescribe()
    }

    @Test
    fun nameDescribeNameSave() {
        Save.nameSave()
        mainName2Describe()
    }

    @Test
    fun nameDescribeCommentSave() {
        Save.commentSave()
        mainNameComment()
    }

    @Test
    fun nameDescribeStarSave() {
        Save.starSave()
        mainNameDescribe()
    }

    @Test
    fun nameDescribeNameCommentSave() {
        Save.nameCommentSave()
        mainName2Comment()
    }

    @Test
    fun nameDescribeStarNameSave() {
        Save.starNameSave()
        mainName2Describe()
    }

    @Test
    fun nameDescribeStarCommentSave() {
        Save.starCommentSave()
        mainNameComment()
    }

    @Test
    fun nameDescribeStarNameCommentSave() {
        Save.starNameCommentSave()
        mainName2Comment()
    }
}
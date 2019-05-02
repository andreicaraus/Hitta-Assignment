package com.hitta.android.assignment.main.tests.functionality

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewDetails
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.util.SetRating.Companion.setRating
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

class StarRating {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)

    @Before
    fun runBefore() {
    }


    /**************
     * DESCRIPTION:
     * Checks if the selected number of stars is matching the selected stars from the Review Details Screen and the small rating bar in the Your Review Section
     */

    @Test
    fun star1() {
        rating(1)
    }

    @Test
    fun star2() {
        rating(2)
    }

    @Test
    fun star3() {
        rating(3)
    }

    @Test
    fun star4() {
        rating(4)
    }

    @Test
    fun star5() {
        rating(5)
    }

    fun rating(stars: Int) {
        reviewsMainBigRatingBar.perform(setRating(stars))
        ReviewDetails().ratingBar { hasRating(stars.toFloat()) }
        ReviewDetails().navigateUp { click() }
        ReviewsMain().smallRatingBar { hasRating(stars.toFloat()) }
    }
}
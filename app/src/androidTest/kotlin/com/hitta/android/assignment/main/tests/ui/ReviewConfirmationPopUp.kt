package com.hitta.android.assignment.main.tests.ui

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.main.base.rules.BaseTestRule
import com.hitta.android.assignment.main.screens.ReviewConfirmation
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class ReviewConfirmationPopUp {

    @Rule
    @JvmField
    var mActivityTestRule = BaseTestRule(MainActivity::class.java)


    /**************
     * DESCRIPTION:
     * Checks that the UI elements from the Save Confirmation PopUp that should be visible for the user are displayed and match the specifications
     */

    @Test
    fun uiReviewsConfirmationPopUp() {
        ReviewConfirmation().alertTitle { isDisplayed() }
        ReviewConfirmation().alertMessage { isDisplayed() }
        ReviewConfirmation().alertYes { isDisplayed() }
    }
}
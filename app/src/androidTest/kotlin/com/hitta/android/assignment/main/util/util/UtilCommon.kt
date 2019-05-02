package com.hitta.android.assignment.main.util.util

import android.support.test.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class UtilCommon {

    companion object {
        private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun isVisible(text: String) {
            val selector = UiSelector().text(text)
            val buttonWidget = device.findObject(selector)
            if (!buttonWidget.waitForExists((500).toLong())) {
                throw Exception()
            }
        }

        //Some could consider it bad practice to have 2 almost identical methods instead of a single one like checkVisibility(visible: Boolean) or to use not in the test, I just chose to use the kakao model who has isDisplayed and isNotDisplayed, isVisible and isInvisible etc.
        fun isNotVisible(text: String) {
            val selector = UiSelector().text(text)
            val buttonWidget = device.findObject(selector)
            if (buttonWidget.waitForExists((500).toLong())) {
                throw Exception()
            }
        }

        val starsMain: Int  = (1..3).random()
        val starsDetails: Int = (4..5).random()
    }
}
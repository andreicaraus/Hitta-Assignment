package com.hitta.android.assignment.main.screens

import android.support.test.espresso.matcher.ViewMatchers.isFocusable
import com.agoda.kakao.KButton
import com.agoda.kakao.KTextView
import com.agoda.kakao.Screen
import com.hitta.android.assignment.R
import com.hitta.android.assignment.main.util.mockDataConstants.MockCommon.Companion.OK
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewConfirmation.Companion.ALERTMESSAGE
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewConfirmation.Companion.ALERTTITLE
import org.hamcrest.Matchers.not

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class ReviewConfirmation: Screen<ReviewConfirmation>() {

    val alertTitle = KTextView {
        withId(R.id.alertTitle)
        withText(ALERTTITLE)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val alertMessage = KTextView {
        withId(android.R.id.message)
        withText(ALERTMESSAGE)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val alertYes = KButton {
        withId(android.R.id.button1)
        withText(OK)
        isEnabled()
        isClickable()
        isFocusable()
    }
}
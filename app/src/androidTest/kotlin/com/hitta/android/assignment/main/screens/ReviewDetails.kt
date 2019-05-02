package com.hitta.android.assignment.main.screens

import android.support.test.espresso.matcher.ViewMatchers.isFocusable
import android.support.test.espresso.matcher.ViewMatchers.withHint
import com.agoda.kakao.*
import com.hitta.android.assignment.R
import com.hitta.android.assignment.main.util.mockDataConstants.MockCommon.Companion.SAVE
import com.hitta.android.assignment.main.util.mockDataConstants.MockCommon.Companion.SHOP1
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.COMMENTHINT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.NAMEHINT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.REVIEW
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.STAR1TEXT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.STAR2TEXT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.STAR3TEXT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.STAR4TEXT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.STAR5TEXT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewDetails.Companion.UPBUTTON
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.startsWith

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class ReviewDetails: Screen<ReviewDetails>() {

    //The content description may be translated in the device's language, so if a test contains this button with this content description, it may fail if the device is not set in English, case not treated for the moment
    val navigateUp = KImageView {
        withContentDescription(UPBUTTON)
        withParent { withId(R.id.action_bar) }
        isEnabled()
        isClickable()
        isFocusable()
    }

    val reviewShopName = KTextView {
        withText(REVIEW + SHOP1)
        withParent { withId(R.id.action_bar) }
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val save = KTextView{
        withId(R.id.save)
        withText(SAVE)
        isEnabled()
        isClickable()
        isFocusable()
    }

    val ratingBar = KRatingBar {
        withId(R.id.rating_bar)
        isEnabled()
        isFocusable()
    }

    val star1Text = KTextView {
        withId(R.id.rate_text)
        withText(STAR1TEXT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val star2Text = KTextView {
        withId(R.id.rate_text)
        withText(STAR2TEXT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val star3Text = KTextView {
        withId(R.id.rate_text)
        withText(STAR3TEXT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val star4Text = KTextView {
        withId(R.id.rate_text)
        withText(STAR4TEXT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val star5Text = KTextView {
        withId(R.id.rate_text)
        withText(STAR5TEXT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val starSeparator = KImageView {
        withId(R.id.rate_score_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val nameEdit = KEditText {
        withId(R.id.name_edit_text)
        withHint(NAMEHINT)
        isEnabled()
        isClickable()
        isFocusable()
    }

    val nameSeparator = KImageView {
        withId(R.id.name_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val commentEdit = KEditText {
        withId(R.id.comment_edit_text)
        withHint(COMMENTHINT)
        isEnabled()
        isClickable()
        isFocusable()
    }

    val commentSeparator = KImageView {
        withId(R.id.comment_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }
}
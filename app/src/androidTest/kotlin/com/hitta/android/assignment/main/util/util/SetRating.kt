package com.hitta.android.assignment.main.util.util

import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.view.View
import android.widget.RatingBar
import org.hamcrest.Matcher
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class SetRating private constructor(private val rating: Int) : ViewAction {

    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(RatingBar::class.java)
    }

    override fun getDescription(): String {
        return "Custom view action to set rating."
    }

    override fun perform(uiController: UiController, view: View) {
        val ratingBar = view as RatingBar
        ratingBar.rating = rating.toFloat()
        ratingBar.onRatingBarChangeListener.onRatingChanged(ratingBar, rating.toFloat(), true)
    }

    companion object {

        fun setRating(rating: Int): SetRating {
            return SetRating(rating)
        }
    }
}
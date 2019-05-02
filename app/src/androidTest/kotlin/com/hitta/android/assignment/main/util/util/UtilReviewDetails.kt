package com.hitta.android.assignment.main.util.util

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.hitta.android.assignment.R

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class UtilReviewDetails {

    companion object {

        val reviewDetailsRatingBar = onView(withId(R.id.rating_bar))
    }
}
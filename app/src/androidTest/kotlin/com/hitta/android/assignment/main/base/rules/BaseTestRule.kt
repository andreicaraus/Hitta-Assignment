package com.hitta.android.assignment.main.base.rules

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import java.util.concurrent.TimeUnit

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class BaseTestRule<T : Activity> : ActivityTestRule<T> {

    constructor(activityClass: Class<T>) : super(activityClass) {}

    constructor(activityClass: Class<T>, initialTouchMode: Boolean) : super(activityClass, initialTouchMode) {}

    constructor(activityClass: Class<T>, initialTouchMode: Boolean, launchActivity: Boolean) : super(
        activityClass,
        initialTouchMode,
        launchActivity
    )

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched();
        InstrumentationRegistry.getTargetContext().deleteDatabase("Reviews.db")
    }

    override fun afterActivityFinished() {
        super.afterActivityFinished();
    }
}
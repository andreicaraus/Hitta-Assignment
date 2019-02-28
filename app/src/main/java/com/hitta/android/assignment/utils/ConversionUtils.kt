package com.hitta.android.assignment.utils

import android.content.res.Resources
import android.text.format.DateUtils
import com.hitta.android.assignment.R

object ConversionUtils {

    private const val ONE_MINUTE = "1"

    fun getDurationStringFromTimestamp(resources: Resources, timestamp: Long): String {
        val currentTimestamp = System.currentTimeMillis()
        val difference = currentTimestamp - timestamp
        return when {
            difference > DateUtils.DAY_IN_MILLIS -> resources.getString(R.string.days_ago, difference.div(DateUtils.DAY_IN_MILLIS).toString())
            difference > DateUtils.HOUR_IN_MILLIS -> resources.getString(R.string.hours_ago, difference.div(DateUtils.HOUR_IN_MILLIS).toString())
            difference > DateUtils.MINUTE_IN_MILLIS -> resources.getString(R.string.minutes_ago, difference.div(DateUtils.MINUTE_IN_MILLIS).toString())
            else -> resources.getString(R.string.minutes_ago, ONE_MINUTE)
        }
    }
}
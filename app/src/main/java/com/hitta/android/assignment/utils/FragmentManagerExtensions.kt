package com.hitta.android.assignment.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun FragmentManager.addFragmentToActivity(fragment: Fragment, frameId: Int) {
    beginTransaction().apply {
        add(frameId, fragment)
    }.commit()
}

fun FragmentManager.replaceFragmentToActivity(fragment: Fragment, frameId: Int) {
    beginTransaction().apply {
        replace(frameId, fragment)
        addToBackStack(fragment::class.java.simpleName)
    }.commit()
}
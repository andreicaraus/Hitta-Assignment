package com.hitta.android.assignment.utils

import android.app.Activity
import android.content.Context
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun AppCompatActivity.setupActionBar(action: ActionBar.() -> Unit) {
    supportActionBar?.run {
        action()
    }
}

fun EditText.setFocusOnInput(activity: Activity) {
    if (!hasFocus()) {
        isFocusable = true
        isFocusableInTouchMode = true
        isCursorVisible = true
        activity.showSoftKeyboard(this)
    }
}

fun EditText.removeFocusFromInput(activity: Activity) {
    activity.hideSoftKeyboard()
    isFocusable = false
    isFocusableInTouchMode = false
    isCursorVisible = false
}

private fun Activity.hideSoftKeyboard() {
    val focusedView = currentFocus
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(focusedView?.windowToken, 0)
}

private fun Activity.showSoftKeyboard(view: View) {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    view.requestFocus()
    inputMethodManager.showSoftInput(view, 0)
    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY)
}
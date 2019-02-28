package com.hitta.android.assignment.common

import android.content.res.Resources

interface BaseView<T> {
    fun setPresenter(presenter: T)

    fun getResources(): Resources

    fun isActive(): Boolean

    fun setTopBarTitle(topBarTitle: String)
}
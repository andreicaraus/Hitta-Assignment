package com.hitta.android.assignment.main.util.util

import android.support.test.espresso.PerformException
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.util.HumanReadables
import android.support.v4.widget.NestedScrollView
import android.view.View
import android.view.ViewParent
import android.widget.FrameLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import android.support.test.espresso.matcher.ViewMatchers.*

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

object NestedScrollTo {

    fun nestedScrollTo(): ViewAction {
        return object : ViewAction {

            override fun getConstraints(): Matcher<View> {
                return Matchers.allOf(
                    isDescendantOfA(isAssignableFrom(NestedScrollView::class.java)),
                    withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
                )
            }

            override fun getDescription(): String {
                return "View is not NestedScrollView"
            }

            override fun perform(uiController: UiController, view: View) {
                try {
                    val nestedScrollView =
                        findFirstParentLayoutOfClass(view, NestedScrollView::class.java) as NestedScrollView?
                    if (nestedScrollView != null) {
                        nestedScrollView.scrollTo(0, view.top)
                    } else {
                        throw Exception("Unable to find NestedScrollView parent.")
                    }
                } catch (e: Exception) {
                    throw PerformException.Builder()
                        .withActionDescription(this.description)
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(e)
                        .build()
                }

                uiController.loopMainThreadUntilIdle()
            }

        }
    }

    private fun findFirstParentLayoutOfClass(view: View, parentClass: Class<out View>): View? {
        var parent: ViewParent? = FrameLayout(view.context)
        var incrementView: ViewParent? = null
        var i = 0
        while (parent != null && parent.javaClass != parentClass) {
            if (i == 0) {
                parent = findParent(view)
            } else {
                parent = findParent(incrementView!!)
            }
            incrementView = parent
            i++
        }
        return parent as View?
    }

    private fun findParent(view: View): ViewParent {
        return view.parent
    }

    private fun findParent(view: ViewParent): ViewParent {
        return view.parent
    }
}

package com.hitta.android.assignment.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.hitta.android.assignment.R
import com.hitta.android.assignment.addeditreview.AddEditReviewFragment
import com.hitta.android.assignment.addeditreview.AddEditReviewPresenter
import com.hitta.android.assignment.common.BaseFragment
import com.hitta.android.assignment.common.dialog.DialogButtonListener
import com.hitta.android.assignment.common.dialog.SimpleDialogFragment
import com.hitta.android.assignment.data.ReviewsRepositoryFactory
import com.hitta.android.assignment.reviews.ReviewsFragment
import com.hitta.android.assignment.reviews.ReviewsPresenter
import com.hitta.android.assignment.utils.addFragmentToActivity
import com.hitta.android.assignment.utils.replaceFragmentToActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startReviewsFragment()
    }

    private fun startReviewsFragment() {
        val reviewsFragment = ReviewsFragment.newInstance()
        supportFragmentManager.addFragmentToActivity(reviewsFragment, R.id.content_frame)
        ReviewsPresenter(ReviewsRepositoryFactory.provideReviewsRepository(this.applicationContext), reviewsFragment)
    }

    fun startAddEditReviewFragment(focusOnComment: Boolean) {
        val addEditReviewFragment = AddEditReviewFragment.newInstance(focusOnComment)
        supportFragmentManager.replaceFragmentToActivity(addEditReviewFragment, R.id.content_frame)
        AddEditReviewPresenter(ReviewsRepositoryFactory.provideReviewsRepository(this.applicationContext), addEditReviewFragment)
    }

    fun showSimpleDialog(title: String, message: String, button: String, listener: DialogButtonListener) {
        val dialogFragment = SimpleDialogFragment.newInstance(title, message, button)
        dialogFragment.setListener(listener)
        dialogFragment.isCancelable = false
        dialogFragment.show(supportFragmentManager, SimpleDialogFragment::class.java.simpleName)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.content_frame) as? BaseFragment
        if (currentFragment != null) {
            currentFragment.onBackPressed()
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }
}
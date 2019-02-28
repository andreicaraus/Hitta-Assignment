package com.hitta.android.assignment.addeditreview

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.hitta.android.assignment.R
import com.hitta.android.assignment.addeditreview.AddEditReviewContract.Presenter
import com.hitta.android.assignment.common.BaseFragment
import com.hitta.android.assignment.common.dialog.DialogButtonListener
import com.hitta.android.assignment.databinding.FragmentAddReviewBinding
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.utils.Constants
import com.hitta.android.assignment.utils.removeFocusFromInput
import com.hitta.android.assignment.utils.setFocusOnInput
import com.hitta.android.assignment.utils.setupActionBar

/**
 * Displays the fragment where the user can add or edit it's review
 */
class AddEditReviewFragment : BaseFragment(), AddEditReviewContract.View {

    private lateinit var presenter: Presenter

    private lateinit var binding: FragmentAddReviewBinding

    companion object {
        fun newInstance(focusOnComment: Boolean): AddEditReviewFragment {
            val bundle = Bundle()
            bundle.putBoolean(Constants.FRAGMENT_ADD_REVIEW_FOCUS_COMMENT_KEY, focusOnComment)
            val fragment = AddEditReviewFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun setPresenter(presenter: Presenter) {
        this.presenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_review, container, false)
        binding.ratingBar.setOnRatingBarChangeListener { _, rating, fromUser -> presenter.onRatingChanged(rating, fromUser) }

        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setupActionBar {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.add_review_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == R.id.save) {
            presenter.onSaveButtonPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.start(arguments?.getBoolean(Constants.FRAGMENT_ADD_REVIEW_FOCUS_COMMENT_KEY) ?: false)
    }

    override fun setTopBarTitle(topBarTitle: String) {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.title = topBarTitle
    }

    override fun isActive(): Boolean = isAdded

    override fun setReviewerName(name: String) {
        binding.nameEditText.setText(name)
    }

    override fun setReviewerComment(comment: String) {
        binding.nameEditText.setText(comment)
    }

    override fun setRatingText(rateText: String) {
        binding.rateText.text = rateText
    }

    override fun setRatingBarValue(rate: Float) {
        binding.ratingBar.rating = rate
    }

    override fun showDialog(title: String, message: String, button: String, listener: DialogButtonListener) {
        val activity = activity as MainActivity
        activity.showSimpleDialog(title, message, button, listener)
    }

    override fun getNameText(): String = binding.nameEditText.text.toString()

    override fun getCommentText(): String = binding.commentEditText.text.toString()

    override fun goToReviewsScreen() {
        activity?.supportFragmentManager?.popBackStack()
    }

    override fun showKeyboardForName() {
        binding.nameEditText.setFocusOnInput(activity as Activity)
    }

    override fun showKeyboardForComment() {
        binding.commentEditText.setFocusOnInput(activity as Activity)
    }

    override fun hideKeyboard() {
        binding.nameEditText.removeFocusFromInput(activity as Activity)
        binding.commentEditText.removeFocusFromInput(activity as Activity)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

}
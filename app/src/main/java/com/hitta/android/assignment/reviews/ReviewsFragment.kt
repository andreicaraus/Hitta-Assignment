package com.hitta.android.assignment.reviews

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hitta.android.assignment.R
import com.hitta.android.assignment.common.BaseFragment
import com.hitta.android.assignment.databinding.FragmentReviewsBinding
import com.hitta.android.assignment.main.MainActivity
import com.hitta.android.assignment.utils.setupActionBar


class ReviewsFragment : BaseFragment(), ReviewsContract.View {

    private lateinit var presenter: ReviewsContract.Presenter

    private lateinit var binding: FragmentReviewsBinding

    companion object {
        fun newInstance(): ReviewsFragment {
            return ReviewsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reviews, container, false)
        binding.yourReviewBigRatingBar.setOnRatingBarChangeListener { _, rating, fromUser -> presenter.onRatingChanged(rating, fromUser) }
        binding.yourReviewDescribeText.setOnClickListener { presenter.onDescribeExperienceTextClicked() }

        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setupActionBar {
            setDisplayShowHomeEnabled(false)
            setDisplayHomeAsUpEnabled(false)
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun isActive(): Boolean = isAdded

    override fun setTopBarTitle(topBarTitle: String) {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.title = topBarTitle
    }

    override fun setSmallRatingBarValue(rate: Float) {
        binding.yourReviewSmallRatingBar.rating = rate
    }

    override fun setName(name: String) {
        binding.yourReviewTitleText.text = name
    }

    override fun setComment(comment: String) {
        binding.yourReviewCommentText.text = comment
    }

    override fun hideBigRatingBar() {
        binding.yourReviewBigRatingBar.visibility = View.GONE
    }

    override fun showSmallRatingBar() {
        binding.yourReviewSmallRatingBar.visibility = View.VISIBLE
    }

    override fun showReviewerHeader() {
        binding.yourReviewHeaderText.visibility = View.VISIBLE
    }

    override fun showReviewerAddComment() {
        binding.yourReviewDescribeText.visibility = View.VISIBLE
        updateViewsDependency(binding.yourReviewDescribeText.id)
    }

    override fun showCommentText() {
        binding.yourReviewCommentText.visibility = View.VISIBLE
        updateViewsDependency(binding.yourReviewCommentText.id)
    }

    override fun showDots() {
        binding.dotsImage.visibility = View.VISIBLE
    }

    override fun setCompanyName(companyName: String) {
        binding.reviewsText.text = companyName
    }

    override fun setReviewerTimestamp(timestamp: String) {
        binding.yourReviewInfoText.text = timestamp
    }

    override fun startAddEditFragment(focusOnComment: Boolean) {
        val activity = activity as MainActivity
        activity.startAddEditReviewFragment(focusOnComment)
    }

    override fun setPresenter(presenter: ReviewsContract.Presenter) {
        this.presenter = presenter
    }

    private fun updateViewsDependency(id: Int) {
        val separatorLayoutParams = binding.yourReviewSectionSeparator.layoutParams as ConstraintLayout.LayoutParams
        separatorLayoutParams.topToBottom = id
        separatorLayoutParams.topMargin = resources.getDimension(R.dimen.review_section_separator_top_margin).toInt()

        val infoTextLayoutParams = binding.yourReviewInfoText.layoutParams as ConstraintLayout.LayoutParams
        infoTextLayoutParams.topToTop = binding.yourReviewSmallRatingBar.id
        infoTextLayoutParams.leftMargin = resources.getDimension(R.dimen.review_section_info_text_start_margin).toInt()
    }
}

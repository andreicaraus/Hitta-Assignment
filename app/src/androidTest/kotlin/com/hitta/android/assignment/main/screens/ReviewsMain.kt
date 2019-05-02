package com.hitta.android.assignment.main.screens

import android.support.test.espresso.matcher.ViewMatchers.isFocusable
import com.agoda.kakao.*
import com.hitta.android.assignment.R
import com.hitta.android.assignment.main.util.mockDataConstants.MockCommon.Companion.SHOP1
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.APPNAME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.LATESTREVIEWSHEADER
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.RATINGAVERAGE
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.RATINGSNUMBER
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW1COMMENT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW1NAME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW1TIME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW2COMMENT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW2NAME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW2TIME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW3COMMENT
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW3NAME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEW3TIME
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.REVIEWS
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.VIEWALL
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.YOURREVIEWDESCRIBE
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.YOURREVIEWHEADER
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.YOURREVIEWINFO
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.YOURREVIEWRATE
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain.Companion.YOURREVIEWTIME
import org.hamcrest.Matchers.not

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class ReviewsMain: Screen<ReviewsMain>() {

    val appName = KTextView {
        withText(APPNAME)
        withParent { withId(R.id.action_bar) }
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    //the name of the button suggests another functionality, but this is not important for the user
    val reviewsShopName = KTextView {
        withId(R.id.reviews_text)
        withText(REVIEWS + SHOP1)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val averageRating = KTextView {
        withId(R.id.total_rating_mock_text)
        withText(RATINGAVERAGE)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val numberRatings = KTextView {
        withText(RATINGSNUMBER)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val viewReviewsTop = KButton {
        withId(R.id.view_all_reviews_top_mock_text)
        withText(VIEWALL)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val reviewsSeparator = KImageView {
        withId(R.id.reviews_section_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    //YOUR RATING - STATE 1, NO STAR SELECTED
    val yourReviewPhoto = KImageView {
        withId(R.id.your_review_image)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val yourReviewRate = KTextView {
        withId(R.id.your_review_title_text)
        withText(YOURREVIEWRATE)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val yourReviewInfo = KTextView {
        withId(R.id.your_review_info_text)
        withText(YOURREVIEWINFO)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val bigRatingBar = KRatingBar {
        withId(R.id.your_review_big_rating_bar)
        isEnabled()
        isFocusable()
    }

    //YOUR RATING - STATE 2, STAR SELECTED, NO COMMENT
    val yourReviewHeader = KTextView {
        withId(R.id.your_review_header_text)
        withText(YOURREVIEWHEADER)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    //the same ID is used as for Rate and review
    val yourReviewName = KTextView {
        withId(R.id.your_review_title_text)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val smallRatingBar = KRatingBar {
        withId(R.id.your_review_small_rating_bar)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    //the same id is used as in the ”Share your experience” text from the first state
    val yourReviewTime = KTextView {
        withId(R.id.your_review_info_text)
        withText(YOURREVIEWTIME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val yourReviewDescribe = KButton {
        withId(R.id.your_review_describe_text)
        withText(YOURREVIEWDESCRIBE)
        isEnabled()
        isClickable()
        isFocusable()
    }

    //In the full version of the app, this is a button, not just an image, that is why it is defined as a button
    val moreOptions = KButton {
        withId(R.id.dots_image)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    //YOUR RATING - STATE 3, ALL ELEMENTS, NOT EDITABLE

    val yourReviewComment = KTextView {
        withId(R.id.your_review_comment_text)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }


    val yourReviewSeparator = KImageView {
        withId(R.id.your_review_section_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val latestReviewsHeader = KTextView {
        withId(R.id.latest_reviews_mock_text)
        withText(LATESTREVIEWSHEADER)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review1Photo = KImageView {
        withId(R.id.review_1_mock_image)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review1Name = KTextView {
        withId(R.id.review_1_mock_title_text)
        withText(REVIEW1NAME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review1Stars = KImageView {
        withId(R.id.review_1_mock_small_rating_bar)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review1Time = KTextView {
        withId(R.id.review_1_mock_info_text)
        withText(REVIEW1TIME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review1Comment = KTextView {
        withId(R.id.review_1_mock_comment_text)
        withText(REVIEW1COMMENT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review1Separator = KImageView {
        withId(R.id.review_1_mock_section_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review2Photo = KImageView {
        withId(R.id.review_2_mock_image)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review2Name = KTextView {
        withId(R.id.review_2_mock_title_text)
        withText(REVIEW2NAME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review2Stars = KImageView {
        withId(R.id.review_2_mock_small_rating_bar)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review2Time = KTextView {
        withId(R.id.review_2_mock_info_text)
        withText(REVIEW2TIME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review2Comment = KTextView {
        withId(R.id.review_2_mock_comment_text)
        withText(REVIEW2COMMENT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review2Separator = KImageView {
        //funny fact, this button should have been named review 2 separator, not 3
        withId(R.id.review_3_mock_section_separator)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review3Photo = KImageView {
        withId(R.id.review_3_mock_image)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review3Name = KTextView {
        withId(R.id.review_3_mock_title_text)
        withText(REVIEW3NAME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review3Stars = KImageView {
        withId(R.id.review_3_mock_small_rating_bar)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review3Time = KTextView {
        withId(R.id.review_3_mock_info_text)
        withText(REVIEW3TIME)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val review3Comment = KTextView {
        withId(R.id.review_3_mock_comment_text)
        withText(REVIEW3COMMENT)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }

    val viewReviewsBottom = KButton {
        withId(R.id.view_all_reviews_bottom_mock_text)
        withText(VIEWALL)
        isEnabled()
        isNotClickable()
        not(isFocusable())
    }
}
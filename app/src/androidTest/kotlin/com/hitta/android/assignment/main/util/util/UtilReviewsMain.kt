package com.hitta.android.assignment.main.util.util

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.hitta.android.assignment.R
import com.hitta.android.assignment.main.screens.ReviewsMain
import com.hitta.android.assignment.main.util.mockDataConstants.MockReviewsMain

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

class UtilReviewsMain {
    companion object {

        val reviewsMainViewReviewsBottom = onView(withId(R.id.view_all_reviews_bottom_mock_text))
        val reviewsMainShopName = onView(withId(R.id.reviews_text))
        val reviewsMainBigRatingBar = onView(withId(R.id.your_review_big_rating_bar))

        fun mainAnonymousDescribe() {
            ReviewsMain().yourReviewName { matches { withText(MockReviewsMain.ANONYMOUS) } }
            ReviewsMain().yourReviewDescribe { isDisplayed() }
        }

        fun mainNameDescribe() {
            ReviewsMain().yourReviewName { matches { withText(MockReviewsMain.MOCKNAMESHORT) } }
            ReviewsMain().yourReviewDescribe { isDisplayed() }
        }

        fun mainName2Describe() {
            ReviewsMain().yourReviewName { matches { withText(MockReviewsMain.MOCKNAMELONG) } }
            ReviewsMain().yourReviewDescribe { isDisplayed() }
        }

        fun mainAnonymousComment() {
            ReviewsMain().yourReviewName { matches { withText(MockReviewsMain.ANONYMOUS) } }
            ReviewsMain().yourReviewComment { isDisplayed() }
        }

        fun mainNameComment() {
            ReviewsMain().yourReviewName { matches { withText(MockReviewsMain.MOCKNAMESHORT) } }
            ReviewsMain().yourReviewComment { isDisplayed() }
        }

        fun mainName2Comment() {
            ReviewsMain().yourReviewName { matches { withText(MockReviewsMain.MOCKNAMELONG) } }
            ReviewsMain().yourReviewComment { isDisplayed() }
        }
    }
}
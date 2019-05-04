package testsuites

import com.hitta.android.assignment.main.tests.functionality.*
import com.hitta.android.assignment.main.tests.ui.ReviewConfirmationPopUp
import com.hitta.android.assignment.main.tests.ui.ReviewDetailsScreen
import com.hitta.android.assignment.main.tests.ui.ReviewsMainScreen
import org.junit.runner.RunWith
import org.junit.runners.Suite

/*
 * Created by Andrei Caraus on 24.04.2019.
 */

@RunWith(value = Suite::class)
@Suite.SuiteClasses(value =

[
    ReviewsMainScreen::class,
    ReviewDetailsScreen::class,
    ReviewConfirmationPopUp::class,
    BackDescribe::class,
    BackNameDescribe::class,
    BackStar::class,
    FieldFocus::class,
    NavigateUpDescribe::class,
    NavigateUpNameDescribe::class,
    NavigateUpStar::class,
    SaveDescribe::class,
    SaveNameDescribe::class,
    SaveStar::class,
    StarRating::class
])

class AllTests

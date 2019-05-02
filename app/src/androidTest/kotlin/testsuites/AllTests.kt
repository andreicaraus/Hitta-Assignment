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
    BackDescribe::class,
    BackNameDescribe::class,
    BackStar::class,
    FieldFocus::class,
    NavigateUpDescribe::class,
    NavigateUpNameDescribe::class,
    NavigateUpStar::class,
    SaveDescribe::class,
    SaveDescribeName::class,
    SaveStar::class,
    StarRating::class,
    ReviewConfirmationPopUp::class,
    ReviewDetailsScreen::class,
    ReviewsMainScreen::class
])

class AllTests

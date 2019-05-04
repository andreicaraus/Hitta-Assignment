package testsuites

import com.hitta.android.assignment.main.tests.ui.*
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
    ReviewConfirmationPopUp::class
])

class UI

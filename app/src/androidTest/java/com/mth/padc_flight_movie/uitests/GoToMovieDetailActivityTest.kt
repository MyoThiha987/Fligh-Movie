package com.mth.padc_flight_movie.uitests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.activities.MainActivity
import com.mth.padc_flight_movie.views.viewholders.MovieListViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailActivityTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToBurgerDetails() {
        Espresso.onView(withId(R.id.rvPopularMovies))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MovieListViewHolder>(0,
                    ViewActions.click()
                ))

        Espresso.onView(withId(R.id.imvBack))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}
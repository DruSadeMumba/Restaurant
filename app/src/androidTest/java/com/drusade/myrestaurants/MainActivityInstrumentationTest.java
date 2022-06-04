package com.drusade.myrestaurants;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.drusade.myrestaurants.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.locationEditText)).perform(typeText("New York"))
                .check(matches(withText("New York")));
    }

    @Test
    public void locationIsSentToRestaurantsActivity() {
        String location = "New York";
        onView(withId(R.id.locationEditText)).perform(typeText(location), closeSoftKeyboard());
        onView(withId(R.id.findRestaurantsButton)).perform(click());
        onView(withId(R.id.locationTextView)).check(matches
                (withText("Here are all the restaurants near: " + location)));

    }
}

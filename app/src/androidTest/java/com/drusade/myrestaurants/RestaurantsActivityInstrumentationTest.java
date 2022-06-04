package com.drusade.myrestaurants;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.RootMatchers.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

import android.view.*;

import androidx.test.core.app.*;
import androidx.test.ext.junit.rules.*;
import androidx.test.ext.junit.runners.*;

import com.drusade.myrestaurants.ui.RestaurantsListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RestaurantsActivityInstrumentationTest {

    private View activityDecorView;

    @Rule
    public ActivityScenarioRule<RestaurantsListActivity> activityTestRule =
            new ActivityScenarioRule<>(RestaurantsListActivity.class);

    @Before
    public void setUp() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<RestaurantsListActivity>() {
            @Override
            public void perform(RestaurantsListActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        String restaurantName = "Haru";
        onData(anything())
                .inAdapterView(withId(R.id.recyclerView))
                .atPosition(5)
                .perform(click());
        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));
    }

}
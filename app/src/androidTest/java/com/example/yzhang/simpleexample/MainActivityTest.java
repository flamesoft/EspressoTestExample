package com.example.yzhang.simpleexample;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.yzhang.simpleexample.Util.TestHelper.sleep;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction weightEditText = onView(allOf(withId(R.id.editTextWeight)));
        weightEditText.perform(replaceText("53"), closeSoftKeyboard());

        ViewInteraction heightEditText = onView(allOf(withId(R.id.editTextHeight)));
        heightEditText.perform(replaceText("162"), closeSoftKeyboard());
        sleep(3000);
        heightEditText.perform(pressImeActionButton());

        ViewInteraction calculateButton = onView(allOf(withId(R.id.textViewCalculate)));
        calculateButton.perform(click());
        sleep(2000);

        ViewInteraction textView = onView(allOf(withId(R.id.textViewTitle)));
        textView.check(matches(withText("Your BMI value is 20.2")));
    }
}

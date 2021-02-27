package com.foxminded.android.task1anagrams;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void espressoUITest() {

        ViewInteraction appCompatEditTextInput = onView(
                allOf(withId(R.id.editTextUserInput),
                        isDisplayed()));
        appCompatEditTextInput.perform(replaceText("adhd5f"));

        ViewInteraction appCompatEditTextFilter = onView(
                allOf(withId(R.id.editTextFilter),
                        isDisplayed()));
        appCompatEditTextFilter.perform(replaceText("5"));

        ViewInteraction textViewOutput = onView(
                allOf(withId(R.id.textViewOutput),
                        isDisplayed()));
        textViewOutput.check(matches(withText("fdhd5a")));

        String[] filterArray = {"", "abrc", "1234567890", "ab"};
        String[] inputArray = {"abcdefg", "abrac", "afht5g", "abracadabra"};
        String[] expectedArray = {"gfedcba", "abrac", "gthf5a", "abradacabra"};
        for (int y = 0; y < 4; y++) {
            appCompatEditTextInput.perform(replaceText(inputArray[y]));
            appCompatEditTextFilter.perform(replaceText(filterArray[y]));
            textViewOutput.check(matches(withText(expectedArray[y])));
        }
    }

    @Test(expected = NullPointerException.class)
    public void espressoUINillExceptionTest() {
        ViewInteraction appCompatEditTextInput = onView(
                allOf(withId(R.id.editTextUserInput),
                        isDisplayed()));
        appCompatEditTextInput.perform(replaceText(null));

    }

}

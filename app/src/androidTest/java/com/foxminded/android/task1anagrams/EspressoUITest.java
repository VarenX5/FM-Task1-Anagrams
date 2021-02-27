package com.foxminded.android.task1anagrams;



import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
public class EspressoUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void espressoUITest() {

        ViewInteraction appCompatEditTextInput = onView(
                allOf(withId(R.id.editTextUserInput),
                        isDisplayed()));

        ViewInteraction appCompatEditTextFilter = onView(
                allOf(withId(R.id.editTextFilter),
                        isDisplayed()));

        ViewInteraction textViewOutput = onView(
                allOf(withId(R.id.textViewOutput),
                        isDisplayed()));

        String[] filterArray = {"", "abrc", "1234567890", "ab", "985sg"};
        String[] inputArray = {"abcdefg", "abrac", "afht5g", "abracadabra","d98mrg s8he's sg5fsh"};
        String[] expectedArray = {"gfedcba", "abrac", "gthf5a", "abradacabra","r98mdg s8'ehs sg5hsf"};
        for (int y = 0; y < filterArray.length; y++) {
            appCompatEditTextInput.perform(replaceText(inputArray[y]));
            appCompatEditTextFilter.perform(replaceText(filterArray[y]));
            textViewOutput.check(matches(withText(expectedArray[y])));
            Spoon.screenshot(mActivityTestRule.getActivity(),"Test_number_"+y);
        }
    }


}

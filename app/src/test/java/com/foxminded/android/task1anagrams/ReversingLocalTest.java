package com.foxminded.android.task1anagrams;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReversingLocalTest {

    @Test
    public void reverseWords() {
        String[] filterArray = {"", "abrc", "1234567890", "ab"};
        String[] inputArray = {"abcdefg", "abrac", "afht5g", "abracadabra"};
        String[] expectedArray = {"gfedcba", "abrac", "gthf5a", "abradacabra"};
        for (int y = 0; y < 4; y++) {
            String actual = Reversing.reverseWords(inputArray[y], filterArray[y]);
            assertEquals(actual, expectedArray[y]);
        }
    }

    @Test(expected = NullPointerException.class)
    public void reverseWordsTestNullInput() {
        String filter = null;
        String input = "Rocks";
        Reversing.reverseWords(input, filter);
    }


}
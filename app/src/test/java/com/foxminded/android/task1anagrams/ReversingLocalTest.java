package com.foxminded.android.task1anagrams;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReversingLocalTest {

    @Test
    public void reverseWords() {
        String[] filterArray = {"", "abrc", "1234567890", "ab", "985sg"};
        String[] inputArray = {"abcdefg", "abrac", "afht5g", "abracadabra", "d98mrg s8he's sg5fsh"};
        String[] expectedArray = {"gfedcba", "abrac", "gthf5a", "abradacabra", "r98mdg s8'ehs sg5hsf"};
        for (int y = 0; y < filterArray.length; y++) {
            String actual = Reversing.reverseWords(inputArray[y], filterArray[y]);
            assertEquals(actual, expectedArray[y]);
        }
    }

    @Test(expected = NullPointerException.class)
    public void reverseWordsTestNullFilter() {
        String filter = null;
        String input = "Rocks";
        Reversing.reverseWords(input, filter);
    }

    @Test(expected = NullPointerException.class)
    public void reverseWordsTestNullInput() {
        String filter = "123";
        String input = null;
        Reversing.reverseWords(input, filter);
    }


}
package com.foxminded.android.task1anagrams;


public class Reversing {

    static String reverseWords(String userInput, String filter) {
        String[] inputWords = userInput.split("\\s");
        StringBuilder stringOutput = new StringBuilder();
        for (String word : inputWords) {
            stringOutput.append(" ").append(reverseWord(word, filter));
        }
        return stringOutput.toString().trim();
    }

    private static String reverseWord(String word, String filter) {
        StringBuilder reversedWordBuilder = new StringBuilder(word);
        int rightIdx = word.length() - 1;
        int leftIdx = 0;

        while (rightIdx > leftIdx) {
            if (isInFilter(filter, word.charAt(leftIdx))) {
                leftIdx++;
            } else if (isInFilter(filter, word.charAt(rightIdx))) {
                rightIdx--;
            } else {
                reversedWordBuilder.setCharAt(leftIdx, word.charAt(rightIdx));
                reversedWordBuilder.setCharAt(rightIdx, word.charAt(leftIdx));
                leftIdx++;
                rightIdx--;
            }
        }

        return reversedWordBuilder.toString();
    }

    private static boolean isInFilter(String filter, char sign) {
        return filter.indexOf(sign) != -1;
    }
}






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
        int currentIndex = word.length() - 1;
        for (int y = 0; y < word.length(); y++) {
            if (!filter.contains(Character.toString(word.charAt(y)))) {
                if (filter.contains(Character.toString(reversedWordBuilder.charAt(currentIndex)))) {
                    while (filter.contains(Character.toString(reversedWordBuilder.charAt(currentIndex)))) {
                        currentIndex--;
                    }
                    reversedWordBuilder.setCharAt(currentIndex, word.charAt(y));
                    currentIndex--;

                } else {
                    reversedWordBuilder.setCharAt(currentIndex, word.charAt(y));
                    currentIndex--;

                }
            }
        }

        return reversedWordBuilder.toString();
    }
}

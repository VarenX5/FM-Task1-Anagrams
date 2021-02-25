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

        while (rightIdx < leftIdx) {
            if (isInFilter(filter, word.charAt(leftIdx))) {
                // TODO: fill
            } else if (isInFilter(filter, word.charAt(rightIdx))) {
                // TODO: fill
            } else {
                // TODO: fill
            }
        }


        int wordBackIndex = word.length() - 1;
        for (int y = 0; y < (word.length() / 2); y++) {
            //checking from left to right
            if (filter.indexOf(word.charAt(y)) == -1) {
                if (filter.indexOf(reversedWordBuilder.charAt(rightIdx)) != -1) {
                    while (filter.indexOf(reversedWordBuilder.charAt(rightIdx)) != -1) {
                        rightIdx--;
                    }
                    reversedWordBuilder.setCharAt(rightIdx, word.charAt(y));
                    rightIdx--;

                } else {
                    reversedWordBuilder.setCharAt(rightIdx, word.charAt(y));
                    rightIdx--;
                }
            }
            //checking from right to left
            if (filter.indexOf(word.charAt(wordBackIndex)) == -1) {
                if (filter.indexOf(reversedWordBuilder.charAt(leftIdx)) != -1) {
                    while (filter.indexOf(reversedWordBuilder.charAt(leftIdx)) != -1) {
                        leftIdx++;
                    }
                    reversedWordBuilder.setCharAt(leftIdx, word.charAt(wordBackIndex));
                    leftIdx++;
                } else {
                    reversedWordBuilder.setCharAt(leftIdx, word.charAt(wordBackIndex));
                    leftIdx++;
                }
            }
            wordBackIndex--;
        }

        return reversedWordBuilder.toString();
    }

    private static boolean isInFilter(String filter, char sign) {
        return filter.indexOf(sign) != -1;
    }
}






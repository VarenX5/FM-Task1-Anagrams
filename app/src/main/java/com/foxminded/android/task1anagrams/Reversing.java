package com.foxminded.android.task1anagrams;


import android.util.Log;

public class Reversing {
    Reversing () {
    }
    static String reverseWords (String userInput, String filter){
        String[] inputWords = userInput.split("\\s");
        String stringOutput = "";
        for (String word : inputWords){
            stringOutput+=" "+ reverseWord(word,filter);
            }
        return(stringOutput.trim());
        }

    private static String reverseWord(String word, String filter){
        StringBuilder reversedWordBuilder = new StringBuilder(word);
        int currentBackIndex = word.length()-1;
        int currentFrontIndex = 0;
        int wordBackIndex = word.length()-1;
        for (int y=0; y<(word.length()/2);y++){
            //checking from left to right
            if(filter.indexOf(word.charAt(y))==-1){ // if character in original word is NOT in the filter
                if(filter.indexOf(reversedWordBuilder.charAt(currentBackIndex))!=-1){ // if character in reversed word is in filter
                    while(filter.indexOf(reversedWordBuilder.charAt(currentBackIndex))!=-1){ //skip if character in reversed word is in filter
                        currentBackIndex--;
                    }
                    reversedWordBuilder.setCharAt(currentBackIndex,word.charAt(y)); //and after skipping we finally add character
                    currentBackIndex--;

                } else { //else just add the character
                    reversedWordBuilder.setCharAt(currentBackIndex,word.charAt(y));
                    currentBackIndex--;
                }
            }
            //checking from right to left
            if(filter.indexOf(word.charAt(wordBackIndex))==-1){
                if(filter.indexOf(reversedWordBuilder.charAt(currentFrontIndex))!=-1){
                    while(filter.indexOf(reversedWordBuilder.charAt(currentFrontIndex))!=-1){ //skip if character in reversed word is in filter
                        currentFrontIndex++;
                    }
                    reversedWordBuilder.setCharAt(currentFrontIndex,word.charAt(wordBackIndex));
                    currentFrontIndex++;
                } else {
                    reversedWordBuilder.setCharAt(currentFrontIndex,word.charAt(wordBackIndex));
                    currentFrontIndex++;
                }
            }
            wordBackIndex--;
        }

        return(reversedWordBuilder.toString());
    }
    }






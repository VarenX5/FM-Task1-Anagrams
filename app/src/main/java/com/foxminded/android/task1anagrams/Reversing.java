package com.foxminded.android.task1anagrams;

import android.util.Log;

import java.util.ArrayList;
public class Reversing {
    Reversing () {
    }
    static String reverseWords (String userInput, String filter){
        //first work with filter
        ArrayList<Character> filterArray = new ArrayList();
        if (!filter.isEmpty()){
            for (int i = 0;i<filter.length();i++){
                if(!filterArray.contains(filter.charAt(i))) {
                    filterArray.add(filter.charAt(i));
                };
            };
        }

        //then reverse all the words
        userInput.trim().replaceAll("\\s+"," ");
        String[] inputWords = userInput.split("\\s");

        String reversedWord;
        String normalWord;
        String stringOutput = "";

        if (filter.isEmpty()){
            for (int i = 0;i<inputWords.length;i++){
                normalWord = inputWords[i];
                reversedWord = "";
                for (int y = 0; y < normalWord.length(); y++) {
                    reversedWord = normalWord.charAt(y) + reversedWord;
                }
                stringOutput = stringOutput + " " + reversedWord;
            }
        }


        if (!filter.isEmpty()){
            for (int i = 0;i<inputWords.length;i++) {
                normalWord = inputWords[i];
                Character[] reversedWordArray = new Character[normalWord.length()];
                reversedWord = "";
                if(normalWord.length()==1){
                    reversedWord = normalWord;
                } else {
                    for (int y=0; y<normalWord.length();y++){
                        if(filterArray.contains(normalWord.charAt(y))){
                            reversedWordArray[y]=normalWord.charAt(y);
                        }
                    }
                    int currentIndex = normalWord.length()-1;
                    for (int y=0; y<normalWord.length();y++){
                        if(!filterArray.contains(normalWord.charAt(y))){
                            if(filterArray.contains(reversedWordArray[currentIndex])){
                                while(filterArray.contains(reversedWordArray[currentIndex])){
                                    currentIndex--;
                                }
                                if(!(currentIndex<0)){
                                    reversedWordArray[currentIndex]=normalWord.charAt(y);
                                    currentIndex--;
                                }

                            } else {
                                if(!(currentIndex<0)){
                                    reversedWordArray[currentIndex]=normalWord.charAt(y);
                                    currentIndex--;
                                }
                            }
                        }
                    }
                    }

                for (int z = 0; z <reversedWordArray.length;z++){
                        if(!(reversedWordArray[z]==null)){
                            reversedWord+=reversedWordArray[z].toString();
                        }
                    }
                stringOutput = stringOutput + " " + reversedWord;
                }
            }
        return(stringOutput.trim());
        }
    }


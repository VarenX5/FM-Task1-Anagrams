package com.foxminded.android.task1anagrams;


import java.util.ArrayList;
public class Reversing {
    Reversing () {
    }
    static String reverseWords (String userInput, String filter){

        String[] inputWords = userInput.split("\\s");
        String stringOutput = "";

        if (!filter.isEmpty()){
            for (int i = 0;i<inputWords.length;i++) {
                String normalWord = inputWords[i];
                Character[] reversedWordArray = new Character[normalWord.length()];
                String reversedWord = "";
                if(normalWord.length()==1){
                    reversedWord = normalWord;
                } else {
                    for (int y=0; y<normalWord.length();y++){
                        if(filter.matches(".*"+normalWord.charAt(y)+".*")){
                            reversedWordArray[y]=normalWord.charAt(y);
                        }
                    }
                    int currentIndex = normalWord.length()-1;
                    for (int y=0; y<normalWord.length();y++){
                        if(!filter.matches(".*"+normalWord.charAt(y)+".*")){
                            if(filter.matches(".*"+reversedWordArray[currentIndex]+".*")){
                                while(filter.matches(".*"+reversedWordArray[currentIndex]+".*")){
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

        String reverseWord(String word, String filter){
            String reversedWord = "";
            if (filter.isEmpty()){
                    for (int y = 0; y < word.length(); y++) {
                        reversedWord = word.charAt(y) + reversedWord;
                    }
                };
            if (!filter.isEmpty()){
                Character[] reversedWordArray = new Character[word.length()];
                    if(word.length()==1){
                        reversedWord = word;
                    } else {
                        for (int y=0; y<word.length();y++){
                            if(filter.matches(".*"+word.charAt(y)+".*")){
                                reversedWordArray[y]=word.charAt(y);
                            }
                        }
                        int currentIndex = word.length()-1;
                        for (int y=0; y<word.length();y++){
                            if(!filter.matches(".*"+word.charAt(y)+".*")){
                                if(filter.matches(".*"+reversedWordArray[currentIndex]+".*")){
                                    while(filter.matches(".*"+reversedWordArray[currentIndex]+".*")){
                                        currentIndex--;
                                    }
                                    if(!(currentIndex<0)){
                                        reversedWordArray[currentIndex]=word.charAt(y);
                                        currentIndex--;
                                    }

                                } else {
                                    if(!(currentIndex<0)){
                                        reversedWordArray[currentIndex]=word.charAt(y);
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
                }
            return(reversedWord);
            }
            }






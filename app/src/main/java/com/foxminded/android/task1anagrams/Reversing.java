package com.foxminded.android.task1anagrams;


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






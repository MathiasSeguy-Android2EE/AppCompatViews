package com.example.appcompatviews;
// 

/**
 * Created by Mathias Seguy also known as Android2ee on 07/05/2019.
 * The goal of this class is to :
 */
public class Vowels {

    public static int getCount(String str) {
        //fast return
        if(str ==null||str.isEmpty()){
            return 0;
        }
        //generic algo
        int vowelsCount = 0;
        char[] letters=str.toCharArray();
        for (char letter : letters) {
            if (letter == 'a' || letter == 'e'
            ||letter == 'i' || letter == 'o'
            || letter == 'u' ){
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

}

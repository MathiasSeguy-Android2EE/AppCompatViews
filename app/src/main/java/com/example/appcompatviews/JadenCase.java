package com.example.appcompatviews;
// 

/**
 * Created by Mathias Seguy also known as Android2ee on 07/05/2019.
 * The goal of this class is to :
 */
public class JadenCase {

    public String toJadenCase(String phrase) {
        //Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
        //Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        StringBuffer strB=new StringBuffer(phrase.length());
        String[] words = phrase.split(" ");
        String firstLetter, restLetters;
        for (String word : words) {
            firstLetter=word.substring(0,1);
            restLetters=word.substring(1);
            strB.append(firstLetter.toUpperCase());
            strB.append(restLetters);
            strB.append(" ");
        }
        //remove last space and return
        String result=strB.toString();
        result= result.substring(0,result.length()-1);

        return result;
    }

}

package com.example.appcompatviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    /**
     * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
     * Finding anagrams in a string
     */
    static List<String> anagramsPair = new ArrayList<>(), anagramsPairIndex = new ArrayList<>();

    static int sherlockAndAnagrams(String initialString) {
        //browse paring
        //parcourir la liste avec des tailles differentes
        int sLenght = initialString.length();
        anagramsPair.clear();
        anagramsPairIndex.clear();
        String currentSubString;
        int numberOfAnagrams = 0;
        int currentAnagramNum = 0;
        for (int length = 1; length < sLenght; length++) {
            for (int index = 0; index <= sLenght - length; index++) {
                //System.out.print("index=" + index + ", length=" + length);
                currentSubString = initialString.substring(index, index + length);
                //System.out.print(" => " + currentSubString);
                //for (int lenght = 1; lenght < sLenght - index; lenght++) {
                //process: You are browsing first substring
                //now you need to do the same to track if this substring belongs to the others string
                currentAnagramNum = countAnagram(currentSubString, initialString, index);
                numberOfAnagrams = numberOfAnagrams + currentAnagramNum;
                //System.out.println(" ");
            }
        }
        //System.out.println("Result");
        for (int i = 0; i < anagramsPair.size(); i++) {
            //System.out.print(anagramsPair.get(i));
            //System.out.print(" at ");
            //System.out.println(anagramsPairIndex.get(i));
        }
        //System.out.println("");
        for (String s : anagramsPair) {
            //System.out.print(s);
        }
        //System.out.println("");
        ////System.out.println("No");
        System.out.println(numberOfAnagrams);
        return numberOfAnagrams;

    }

    static int countAnagram(String searchedString, String searchingSetString, int forbiddenIndex) {
        //parcourir la liste avec des tailles differentes
        int sLenght = searchingSetString.length();
        int searchedStrLenght = searchedString.length();
        String current;
        int anagramsFoundNumber = 0;
        for (int index = forbiddenIndex; index <= sLenght - searchedStrLenght; index++) {
            if (index == forbiddenIndex) {
                //skip
            } else {
                current = searchingSetString.substring(index, index + searchedStrLenght);
                //for (int lenght = 1; lenght < sLenght - index; lenght++) {
                if (isSame(searchedString, current)) {
                    ////System.out.println("Yes");
                    ////System.out.println(s1.substring(index, index + lenght));
                    //System.out.print(" *");
                    anagramsFoundNumber++;
                    anagramsPair.add("[" + searchedString + "," + current + "]");
                    anagramsPairIndex.add("[" + forbiddenIndex + " => " + index + " [" + searchedStrLenght + "]");
                }
            }
        }
        return anagramsFoundNumber;
    }

    static boolean isSame(String str1, String str2) {
        Character currentChar;
        //two strings are the same if they have te same set of letters
        //first fill the map for the first element (know each letters number)
        HashMap<Character, Integer> fromLetterToNumber = new HashMap<>(26);
        for (int i = 0; i < str1.length(); i++) {
            currentChar = str1.charAt(i);
            if (fromLetterToNumber.containsKey(currentChar)) {
                fromLetterToNumber.put(currentChar, fromLetterToNumber.get(currentChar) + 1);
            } else {
                fromLetterToNumber.put(currentChar, 1);
            }
        }
        //Second do the same for the second string
        HashMap<Character, Integer> fromLetterToNumber2 = new HashMap<>(26);
        for (int i = 0; i < str2.length(); i++) {
            currentChar = str2.charAt(i);
            if(!fromLetterToNumber.containsKey(currentChar)){
                return false;
            }
            if (fromLetterToNumber2.containsKey(currentChar)) {
                fromLetterToNumber2.put(currentChar, fromLetterToNumber2.get(currentChar) + 1);
            } else {
                fromLetterToNumber2.put(currentChar, 1);
            }
        }
        //then compare both sets:
        Iterator it = fromLetterToNumber.entrySet().iterator();
        Map.Entry pair;
        int str2CharOccurence;
        Integer str1CharOccurence;
        Character key;
        while (it.hasNext()) {
            pair = (Map.Entry) it.next();
            key = (Character) pair.getKey();
            str1CharOccurence = (Integer) pair.getValue();
            //the key belongs to both strings
            if (fromLetterToNumber2.containsKey(key)) {
                str2CharOccurence = fromLetterToNumber2.get(key);
                if (str1CharOccurence != str2CharOccurence) {
                    //all bad: not the same number of occurence of the char
                    return false;
                }
            } else {
                //all bad: a char in str2 doesn't belong to a char in str1
                return false;
            }

        }
        //all good
        return true;
    }


    /***********************************************************
     *  Exo HashMap 1
     **********************************************************/
    static String twoStrings(String s1, String s2) {
        //parcourir la liste avec des tailles differentes
        int sLenght = s1.length();
        HashMap<String, Boolean> allreadyDone = new HashMap<>(26);
        String current;
        for (int index = 0; index < sLenght; index++) {
            current = s1.substring(index, index + 1);
            //for (int lenght = 1; lenght < sLenght - index; lenght++) {
            if (allreadyDone.containsKey(current)) {
                //do nothing
            } else {
                allreadyDone.put(current, Boolean.TRUE);
                if (s2.contains(s1.substring(index, index + 1))) {
                    //System.out.println("Yes");
                    //System.out.println(s1.substring(index, index + lenght));
                    return "YES";
                }
                //}
            }
        }
        //System.out.println("No");
        return "NO";
    }

    /***********************************************************
     *  Exo HashMap 0:
     *  Know if the first arrary (magazine) contains the second array
     **********************************************************/
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magLetterToOccurence = new HashMap<>(magazine.length);
        HashMap<String, Integer> noteLetterToOccurence = new HashMap<>(note.length);
        //fill
        for (String s : magazine) {
            //System.out.println("analyzing "+s);
            if (magLetterToOccurence.containsKey(s)) {
                magLetterToOccurence.put(s, magLetterToOccurence.get(s) + 1);
            } else {
                magLetterToOccurence.put(s, 1);
            }
        }
        for (String s : note) {
            //System.out.println("analyzing "+s);
            if (noteLetterToOccurence.containsKey(s)) {
                noteLetterToOccurence.put(s, noteLetterToOccurence.get(s) + 1);
            } else {
                noteLetterToOccurence.put(s, 1);
            }
        }
        //check
        Iterator it = noteLetterToOccurence.entrySet().iterator();
        Map.Entry pair;
        int magazineValue;
        Integer noteValue;
        String key;
        while (it.hasNext()) {
            pair = (Map.Entry) it.next();
            key = (String) pair.getKey();
            noteValue = (Integer) pair.getValue();
            if (magLetterToOccurence.containsKey(key)) {
                magazineValue = magLetterToOccurence.get(key);
                if (noteValue > magazineValue) {
                    System.out.print("No");
                    return;
                }
            } else {
                System.out.print("No");
                return;
            }

        }
        System.out.print("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

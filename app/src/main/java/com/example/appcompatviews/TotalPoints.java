package com.example.appcompatviews;
// 

/**
 * Created by Mathias Seguy also known as Android2ee on 07/05/2019.
 * The goal of this class is to :
 * Our football team finished the championship. The result of each match look like "x:y". Results of all matches are recorded in the collection.
 *
 * For example: ["3:1", "2:2", "0:1", ...]
 *
 * Write a function that takes such collection and counts the points of our team in the championship. Rules for counting points for each match:
 *
 * if x>y - 3 points
 * if x<y - 0 point
 * if x=y - 1 point
 * Notes:
 *
 * there are 10 matches in the championship
 * 0 <= x <= 4
 * 0 <= y <= 4
 */
public class TotalPoints {

    public static int points(String[] games) {
        //fast return
        if(games == null || games.length !=10){
            return 0;
        }
        //generic algo
        int totalScore=0;
        //don't declare variable in loop
        String[] splittedString;
        //browse the array
        for (String game : games) {
            //Split 3:1 into [3,1]
            splittedString=game.split(":");
            //find your value
            totalScore=totalScore+getValue(splittedString[0],splittedString[1]);
        }
        return totalScore;
    }

    /**
     * Buisness rule implementation of the scoring
     * @param scoreOurTeam
     * @param scoreOtherTeam
     * @return the score for the year count of point
     */
    public static int getValue(String scoreOurTeam,String scoreOtherTeam){
        //move your string to integer
        Integer ourScore,othersScore;
        ourScore=Integer.valueOf(scoreOurTeam);
        othersScore=Integer.valueOf(scoreOtherTeam);
        //then compare and return
        if(ourScore>othersScore){
            return 3;
        }else if(ourScore == othersScore){
            return 1;
        }else {
            return 0;
        }
    }
}

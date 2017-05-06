package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/rookierank-3/challenges/comparing-times>Comparing Times</a>
 * Max Score: 15 Difficulty: Easy
 */
public class ComparingTimes {

    static String timeCompare(String t1, String t2){
        String[] t1Tokens = parseTime(t1);
        String[] t2Tokens = parseTime(t2);
        boolean t1BeforeNoon = beforeNoon(t1Tokens[2]);
        boolean t2BeforeNoon = beforeNoon(t2Tokens[2]);
        if (t1BeforeNoon && !t2BeforeNoon) {
            return "First";
        }
        if (t2BeforeNoon && !t1BeforeNoon) {
            return "Second";
        }
        // t1 and t2 occur in the same half of the day
        int t1Hours = Integer.parseInt(t1Tokens[0]) % 12;
        int t2Hours = Integer.parseInt(t2Tokens[0]) % 12;
        if (t1Hours == t2Hours) {
            int t1Minutes = Integer.parseInt(t1Tokens[1]);
            int t2Minutes = Integer.parseInt(t2Tokens[1]);
            // Problem states that t1 != t2, therefore we don't have to check whether t1 and t2 minutes are the same
            return (t1Minutes < t2Minutes) ? "First" : "Second";
        }
        return (t1Hours < t2Hours) ? "First" : "Second";
    }

    private static String[] parseTime(String t) {
        int indexOfDelim = t.indexOf(':');
        int indexOfSuffix = t.length() - 2;
        String hours = t.substring(0, indexOfDelim);
        String minutes = t.substring(indexOfDelim + 1, indexOfSuffix);
        String suffix = t.substring(indexOfSuffix);
        return new String[]{hours, minutes, suffix};
    }

    private static boolean beforeNoon(String suffix) {
        return suffix.equalsIgnoreCase("AM");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String t1 = in.next();
            String t2 = in.next();
            String result = timeCompare(t1, t2);
            System.out.println(result);
        }
    }
}

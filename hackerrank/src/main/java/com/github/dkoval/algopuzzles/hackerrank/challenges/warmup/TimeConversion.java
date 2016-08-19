package com.github.dkoval.algopuzzles.hackerrank.challenges.warmup;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/time-conversion">Problem:</a>
 * * Max Score: 15 Difficulty: Easy
 */
public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time12Hour = in.nextLine();
        String time24Hour = solve(time12Hour);
        System.out.println(time24Hour);
    }

    static String solve(String time12Hour) {
        // Parse either hh:mm:ssAM or hh:mm:ssPM string
        int hh = Integer.valueOf(time12Hour.substring(0, 2));
        int mm = Integer.valueOf(time12Hour.substring(3, 5));
        int ss = Integer.valueOf(time12Hour.substring(6, 8));
        String period = time12Hour.substring(8);
        // AM/PM to 24-hour format conversion
        if ("AM".equalsIgnoreCase(period)) {
            // AM
            if (hh == 12) {
                // Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock
                hh = 0;
            }
        } else {
            // PM
            if (hh < 12) {
                // Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock
                hh += 12;
            }
        }
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
}

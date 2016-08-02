package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/the-time-in-words">Problem:</a>
 * Max Score: 25 Difficulty: Moderate
 */
public class TimeInWords {
    static String[] basics = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "quarter",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"};

    static String[] dozens = {
            "twenty",
            "thirty",
            "forty",
            "fifty"
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String answer = solve(h, m);
        System.out.println(answer);
    }

    /* 1 <= h < 12, 0 <= m < 60 */
    static String solve(int h, int m) {
        StringBuilder answer = new StringBuilder();
        if (m == 0) {
            answer.append(toWord(h))
                    .append(" o' clock");
        } else if (m == 30) {
            answer.append("half past ")
                    .append(toWord(h));
        } else {
            String orientation = " past ";
            if (m > 30) {
                m = 60 - m;
                h = h + 1;
                orientation = " to ";
            }
            answer.append(toWord(m));
            if (m != 15) {
                answer.append(" minute");
                if (m > 1) {
                    answer.append('s');
                }
            }
            answer.append(orientation).append(toWord(h));
        }
        return answer.toString();
    }

    // 1 <= x <= 59
    private static String toWord(int x) {
        if (x < 20) {
            return basics[x - 1];
        } else {
            String word = dozens[x / 10 - 2];
            int rem = x % 10;
            if (rem != 0) {
                word += " " + basics[rem - 1];
            }
            return word;
        }
    }
}

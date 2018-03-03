package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/separate-the-numbers/problem">Separate the Numbers</a>
 * Max Score: 20, Difficulty: Easy
 */
public class SeparateNumbers {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                String answer = separateNumbers(s);
                System.out.println(answer);
            }
        }
    }

    static String separateNumbers(String s) {
        // consider each possible starting number
        for (int i = 1; i <= s.length() / 2; i++) {
            String str = s.substring(0, i);
            long num = Long.parseLong(str);
            String seq = generateSequence(num, s.length());
            if (seq.equals(s)) {
                return "YES " + num;
            }
        }
        return "NO";
    }

    private static String generateSequence(long start, int size) {
        StringBuilder seq = new StringBuilder();
        seq.append(start);
        while (seq.length() < size) {
            seq.append(++start);
        }
        return seq.toString();
    }
}

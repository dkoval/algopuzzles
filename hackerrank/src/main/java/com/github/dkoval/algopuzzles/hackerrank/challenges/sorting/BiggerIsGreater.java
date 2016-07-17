package com.github.dkoval.algopuzzles.hackerrank.challenges.sorting;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/bigger-is-greater">Problem:</a>
 * Max Score: 35 Difficulty: Moderate
 */
public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();
        while (t > 0) {
            String s = in.nextLine();
            String answer = solve(s);
            System.out.println(answer != null ? answer : "no answer");
            t--;
        }
    }

    // Good reading: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    static String solve(String str) {
        char[] s = str.toCharArray();
        // scan from right to left, find the first element that is less than its previous one
        int i = s.length - 1;
        while (i > 0 && s[i - 1] >= s[i]) {
            i--;
        }
        // no answer exists
        if (i <= 0) {
            return null;
        }
        // scan from right to left, find the first element that is greater than s[i - 1]
        int j = s.length - 1;
        while (j >= i && s[j] <= s[i - 1]) {
            j--;
        }
        // swap s[j] and s[i − 1]
        swap(s, i - 1, j);
        // reverse the suffix starting from s[i]
        reverse(s, i, s.length - 1);
        return new String(s);
    }

    private static char[] swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        return s;
    }

    private static char[] reverse(char[] s, int begin, int end) {
        while (begin < end) {
            swap(s, begin, end);
            begin++;
            end--;
        }
        return s;
    }
}

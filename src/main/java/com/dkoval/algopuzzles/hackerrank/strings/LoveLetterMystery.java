package com.dkoval.algopuzzles.hackerrank.strings;

import java.util.Scanner;

/**
 * Created by null on 3/23/16.
 */
public class LoveLetterMystery {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numTestCases; i++) {
            String input = scan.nextLine();
            int answer = minNumOfOpsToFormPalindrome(input);
            System.out.println(answer);
        }
        scan.close();
    }

    public static int minNumOfOpsToFormPalindrome(String input) {
        final int N = input.length();
        int numOfOps = 0;
        for (int i = 0; i < N / 2; i++) {
            char lch = input.charAt(i);
            char rch = input.charAt(N - i - 1);
            // Rule #1: He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
            // Rule #2: Once a letter has been changed to a, it can no longer be changed.
            while (lch != rch) {
                // always try to reduce a 'greater' letter
                if (rch > lch) {
                    rch -= 1;
                } else {
                    lch -= 1;
                }
                numOfOps++;
            }
        }
        return numOfOps;
    }
}

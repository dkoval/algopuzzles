package com.github.dkoval.algopuzzles.hackerrank.contests.w31;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w31/challenges/zero-one-game">Problem:</a>
 * Max Score: 40 Difficulty: Medium
 */
public class ZeroOneGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        while (g-- > 0) {
            int n = in.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = in.nextInt();
            }
            // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
            String ans = solve(sequence);
            System.out.println(ans);
        }
    }

    public static String solve(int[] sequence) {
        int numMoves = 0;
        int subseqElem = sequence[0], contSubseqLength = 1;
        for (int i = 1; i < sequence.length; i++) {
            // count number of occurrences of `010` in the sequence
            if (i < sequence.length - 1 && sequence[i - 1] == 0 && sequence[i] == 1 && sequence[i + 1] == 0) {
                numMoves++;
                continue;
            }
            // find contiguous sub-sequences made up of `0`s
            if (sequence[i] != subseqElem) {
                if (subseqElem == 0 && contSubseqLength > 2) {
                    numMoves += contSubseqLength - 2;
                }
                // reset counters
                subseqElem = sequence[i];
                contSubseqLength = 1;
            } else {
                contSubseqLength++;
            }
        }
        // check if a contiguous sub-sequence consisting made up of `0`s appears at the end of the sequence
        if (subseqElem == 0 && contSubseqLength > 2) {
            numMoves += contSubseqLength - 2;
        }
        // make a decision
        return (numMoves % 2 != 0) ? "Alice" : "Bob";
    }
}

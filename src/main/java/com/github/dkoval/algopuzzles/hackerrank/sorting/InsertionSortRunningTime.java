package com.github.dkoval.algopuzzles.hackerrank.sorting;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/runningtime">Problem:</a>
 * Max Score: 30 Difficulty: Easy
 */
public class InsertionSortRunningTime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        int answer = numOfShifts(ar);
        System.out.println(answer);
    }

    static int numOfShifts(int[] ar) {
        int numOfShifts = 0;
        for (int i = 1; i < ar.length; i++) {
            int key = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > key) {
                // shift one cell to the right
                ar[j + 1] = ar[j];
                numOfShifts++;
                j--;
            }
            ar[j + 1] = key;
        }
        return numOfShifts;
    }
}

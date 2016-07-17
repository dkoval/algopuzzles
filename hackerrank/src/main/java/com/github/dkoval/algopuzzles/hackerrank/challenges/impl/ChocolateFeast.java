package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/chocolate-feast">Problem:</a>
 * Max Score: 25 Difficulty: Easy
 */
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int answer = solve(n, c, m);
            System.out.println(answer);
            t--;
        }
    }

    static int solve(int n, int c, int m) {
        int numOfChocolates = n / c;
        int answer = numOfChocolates, numOfWrappers = numOfChocolates;
        do {
            numOfChocolates = numOfWrappers / m;
            numOfWrappers = numOfWrappers % m + numOfChocolates;
            answer += numOfChocolates;
        } while (numOfWrappers >= m);
        return answer;
    }
}

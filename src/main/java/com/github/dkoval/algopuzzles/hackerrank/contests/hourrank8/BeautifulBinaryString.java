package com.github.dkoval.algopuzzles.hackerrank.contests.hourrank8;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/hourrank-8/challenges/beautiful-binary-string">Problem:</a>
 * Max Score: 25 Difficulty: Easy
 * <p>
 * Alice has a binary string, B, of length n. She thinks a binary string is beautiful if and only if it
 * doesn't contain the substring "010".
 * <p>
 * In one step, Alice can change a 0 to a 1 (or vice-versa). Count and print the minimum number of steps needed
 * to make Alice see the string as beautiful.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, n (the length of binary string B).
 * The second line contains a single binary string, B, of length n.
 * <p>
 * Constraints
 * <ul>
 * <li>1<=n<=100</li>
 * <li>Each character in B∈{0,1}</li>
 * </ul>
 * Output Format
 * <p>
 * Print the minimum number of steps needed to make the string beautiful.
 */
public class BeautifulBinaryString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int answer = solve(s);
        System.out.println(answer);
    }

    static int solve(String s) {
        // greedy approach - whenever 010 substring is encountered, replace it with 011
        int numOfSteps = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length() - 2; i++) {
            if (ch[i] == '0' && ch[i + 1] == '1' && ch[i + 2] == '0') {
                ch[i + 2] = '1';
                numOfSteps++;
            }
        }
        return numOfSteps;
    }
}

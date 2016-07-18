package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/manasa-and-stones">Problem:</a>
 * Max Score: 30 Difficulty: Easy
 */
public class ManasaAndStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            String answer = solve(n, a, b);
            System.out.println(answer);
            t--;
        }
    }

    static String solve(int n, int a, int b) {
        Set<Integer> answer = doSolve(n, a, b);
        return answer.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    static Set<Integer> doSolve(int n, int a, int b) {
        Set<Integer> answer = new LinkedHashSet<>();
        int aa = Math.min(a, b);
        int bb = Math.max(a, b);
        // min last stone value = aa * (n - 1), max last stone value = bb * (n - 1)
        for (int i = 0; i < n; i++) {
            int lastStone = i * bb + (n - i - 1) * aa;
            answer.add(lastStone);
        }
        return answer;
    }
}

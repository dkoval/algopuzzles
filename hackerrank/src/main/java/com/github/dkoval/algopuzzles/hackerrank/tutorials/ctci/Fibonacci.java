package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem">Recursion: Fibonacci Numbers</a>
 * Max Score: 15 Difficulty: Easy
 */
public class Fibonacci {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            System.out.println(fibonacci(n));
        }
    }

    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

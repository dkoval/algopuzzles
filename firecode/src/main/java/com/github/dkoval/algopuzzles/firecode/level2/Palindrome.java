package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Write a method that checks if a given integer is a palindrome without allocating additional heap space.
 */
public class Palindrome {

    public static Boolean isIntPalindrome(int x) {
        int direct = x, reverse = 0;
        while (x > 0) {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x /= 10;
        }
        return direct == reverse;
    }
}

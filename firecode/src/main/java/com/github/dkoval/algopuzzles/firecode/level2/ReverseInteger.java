package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Implement a method that reverses an integer - without using additional heap space.
 */
public class ReverseInteger {

    public static int reverseInt(int x) {
        int reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return reversed;
    }
}

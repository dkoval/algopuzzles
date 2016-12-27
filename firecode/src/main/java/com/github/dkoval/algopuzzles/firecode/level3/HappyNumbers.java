package com.github.dkoval.algopuzzles.firecode.level3;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a method to determine whether a positive number is Happy.
 * <p>
 * A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below:
 * Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1
 * or loops endlessly in a cycle that does not include 1.
 */
public class HappyNumbers {

    public static boolean isHappyNumber(int n) {
        Set<Integer> alreadySeenNumbers = new HashSet<>();
        do {
            n = sumOfSquaresOfDigits(n);
            if (!alreadySeenNumbers.add(n)) {
                return false;
            }
        } while (n != 1);
        return true;
    }

    private static int sumOfSquaresOfDigits(int n) {
        int res = 0;
        while (n != 0) {
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }
        return res;
    }
}

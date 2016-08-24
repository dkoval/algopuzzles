package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Write a method to compute the binary representation of a positive integer.
 * The method should return a string with 1s and 0s.
 */
public class BinaryRepresentation {

    public static String computeBinary(int val) {
        if (val == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            int binDigit = val % 2;
            sb.append((char)('0' + binDigit));
            val /= 2;
        }
        return sb.reverse().toString();
    }
}

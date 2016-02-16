package com.nohup.epi.ch5.primitive;

/**
 * EPI, Problem 5.2 p.47: A 64-bit can be viewed as an array of 64 bits, with the bit at index 0
 * corresponding to the least significant bit, and the bit at index 63 corresponding to the most
 * significant bit. Implement code that takes a 64-bit integer x and swaps the bits at indices i and j.
 */
public class SwapBits {

    public static long solution(long x, int i, int j) {
        // if bits at indices i and j are the same, do nothing
        if (getBitAtIndex(x, i) != getBitAtIndex(x, j)) {
            // at this point, we only have to handle 2 cases:
            // b(i) = 0 and b(j) = 1, or
            // b(i) = 1 and b(j) = 0

            // In terms of swap operation, it means that if b(i) (or b(j))
            // equals to 0, it must be replaced with 1 and vice versa.
            // This can be achieved with the help of bit mask and XOR operation.
            long mask = (1L << i) | (1L << j);
            x ^= mask;
        }
        return x;
    }

    private static byte getBitAtIndex(long x, int k) {
        return (byte) ((x >> k) & 1);
    }
}

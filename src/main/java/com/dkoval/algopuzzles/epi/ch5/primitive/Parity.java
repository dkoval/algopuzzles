package com.dkoval.algopuzzles.epi.ch5.primitive;

/**
 * <a href="http://judge.elementsofprogramminginterviews.com:8080/post/parity">Problem:</a>
 * <p>
 * How would you compute the parity of a very large number of 64-bit words?
 * I.e. whether the number of 1's in the binary representation is even or odd?
 * Hint: encode the parity information as:
 * <ul>
 * <li>1 - parity of the bit set is odd</li>
 * <li>0 - parity of the bit set is even</li>
 * </ul>
 * </p>
 */
public class Parity {

    public static short solution(long x) {
        // The parity P of a set S of 2 bits can be computed using XOR operation:
        //
        // 0 ^ 0 = 0 - parity is even
        // 0 ^ 1 = 1 - parity is odd
        // 1 ^ 0 = 1 - parity is odd
        // 1 ^ 1 = 0 - parity is even
        //
        // Observation: if S = S1 union S2, then P(S) = P(S1) ^ P(S2)
        //
        // Solution: start by grouping the bits in subsets of two bits (two adjacent bits),
        // then perform the parity check on those subsets. Then check the parity of the next-bigger
        // sets of 4 bits by using the parity of the 2-bits subsets just computed. Then go on with
        // 8-bits, 16-bits and, finally, 32-bits subsets.
        for (int i = 1; i < 64; i *= 2) {
            x ^= x >> i;
        }
        return (short) (x & 1);
    }
}

package com.github.dkoval.algopuzzles.hackerrank.challenges.bits;

import java.util.Objects;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/aorb/problem">A or B</a>
 * Max Score: 50 Difficulty: Medium
 */
public class AorB {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                int k = in.nextInt();
                String a = in.next();
                String b = in.next();
                String c = in.next();
                Answer ans = solve(k, a, b, c);
                if (ans != null) {
                    System.out.println(ans.a);
                    System.out.println(ans.b);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }

    static Answer solve(int k, String a, String b, String c) {
        int n = Math.max(Math.max(a.length(), b.length()), c.length());
        byte[] A = hexStringToDec(a, n);
        byte[] B = hexStringToDec(b, n);
        byte[] C = hexStringToDec(c, n);

        // change bits of A and B if needed
        for (int i = n - 1; i >= 0; i--) {
            // each a[i], b[i], c[i] is in [0..15] range (4 bits)
            for (int j = 3; j >= 0; j--) {
                if ((C[i] & (1 << j)) == 0) { // C[m] == 0
                    if ((A[i] & (1 << j)) != 0) { // A[m] != 0
                        // clear m-th bit of A
                        A[i] ^= (1 << j);
                        k--;
                    }
                    if ((B[i] & (1 << j)) != 0) { // B[m] != 0
                        // clear m-th bit of B
                        B[i] ^= (1 << j);
                        k--;
                    }
                } else {
                    if (((A[i] | B[i]) & (1 << j)) == 0) { // A[m] == B[m] == 0
                        // set m-th bit of B
                        B[i] ^= (1 << j);
                        k--;
                    }
                }
            }
        }

        if (k < 0) {
            return null;
        }

        // attempt to further minimize the value of A
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                if ((A[i] & (1 << j)) != 0) { // A[m] != 0
                    if ((B[i] & (1 << j)) != 0) { // B[m] != 0
                        if (k >= 1) {
                            // clear m-th bit of A
                            A[i] ^= (1 << j);
                            k--;
                        }
                    } else {
                        if (k >= 2) {
                            // clear m-th bit of A
                            A[i] ^= (1 << j);
                            // set m-th bit of B
                            B[i] ^= (1 << j);
                            k -= 2;
                        }
                    }
                }
            }
        }

        return new Answer(decToHexString(A), decToHexString(B));
    }

    private static byte[] hexStringToDec(String str, int size) {
        int n = Math.max(str.length(), size);
        byte[] res = new byte[n];
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            res[n - i - 1] = (ch >= '0' && ch <= '9') ? (byte) (ch - '0') : (byte) (ch - 'A' + 10);
        }
        return res;
    }

    private static String decToHexString(byte[] dec) {
        StringBuilder str = new StringBuilder();
        boolean leadingZero = true;
        for (int i = dec.length - 1; i >= 0; i--) {
            char ch = (dec[i] < 10) ? (char) (dec[i] + '0') : (char) (dec[i] - 10 + 'A');
            if (ch != '0') {
                leadingZero = false;
            }
            if (!leadingZero) {
                str.append(ch);
            }
        }
        if (leadingZero) {
            str.append('0');
        }
        return str.toString();
    }

    static class Answer {
        final String a;
        final String b;

        Answer(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Answer answer = (Answer) o;
            return Objects.equals(a, answer.a) &&
                    Objects.equals(b, answer.b);
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "a='" + a + '\'' +
                    ", b='" + b + '\'' +
                    '}';
        }
    }
}

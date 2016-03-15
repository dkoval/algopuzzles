package com.dkoval.algopuzzles.epi.ch6.strings;

/**
 * <a href="http://judge.elementsofprogramminginterviews.com:8080/post/base-conversion">Problem:</a>
 * <p>
 * Write a program that performs base conversion.
 * </p>
 */
public class BaseConversion {

    public static String solution(String s, int b1, int b2) {
        // Assume b1, b2 are in [2..16] range
        // The solution is to convert base b1 string to a base 10 integer,
        // and then convert it to a base b2 string
        int n = toDecimal(s, b1);
        return toString(n, b2);
    }

    private static int toDecimal(String s, int base) {
        boolean isNeg = s.charAt(0) == '-';
        int answer = 0;

        for (int i = isNeg ? 1 : 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer *= base;
            answer += toDigit(c);
        }
        return isNeg ? -answer : answer;
    }

    private static String toString(int n, int base) {
        boolean isNeg = n < 0;
        if (isNeg) {
            n = -n;
        }

        StringBuilder buff = new StringBuilder();
        while (n != 0) {
            int digit = n % base;
            n /= base;
            buff.append(toChar(digit));
        }

        // while loop did not execute, meaning that input n = 0
        if (buff.length() == 0) {
            buff.append('0');
        }
        // add '-' symbol if input n is a negative number
        if (isNeg) {
            buff.append('-');
        }
        return buff.reverse().toString();
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private static int toDigit(char c) {
        return isDigit(c) ? c - '0' : c - 'A' + 10;
    }

    private static char toChar(int digit) {
        int asciiCode = (digit >= 10) ? 'A' + digit - 10 : '0' + digit;
        return (char) asciiCode;
    }
}

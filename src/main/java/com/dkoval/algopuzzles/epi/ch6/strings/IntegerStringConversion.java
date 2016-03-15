package com.dkoval.algopuzzles.epi.ch6.strings;

/**
 * <a href="http://judge.elementsofprogramminginterviews.com:8080/post/integer-string-conversion">Problem:</a>
 * <p>
 * A string is a sequence of characters. A string may encode an integer, e.g., "123" encodes 123.
 * In this problem, you are to implement methods that take a string representing an integer and return
 * the corresponding integer, and vice versa. Your code should handle negative integers.
 * You cannot use library functions like stoi in C++ and parseInt in Java.
 * </p>
 */
public class IntegerStringConversion {

    public static String intToString(int x) {
        boolean isNeg = x < 0;
        if (isNeg) {
            x = -x;
        }

        StringBuilder buff = new StringBuilder();
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            buff.append((char) (digit + '0'));
        }

        // while loop did not execute, meaning that input x = 0
        if (buff.length() == 0) {
            buff.append('0');
        }
        // add '-' symbol if input x is a negative number
        if (isNeg) {
            buff.append('-');
        }
        return buff.reverse().toString();
    }

    public static int stringToInt(String s) {
        if (s == null) {
            throw new NumberFormatException("Input string is null");
        }

        if (s.isEmpty()) {
            throw new NumberFormatException("Input string is empty");
        }

        boolean isNeg = s.charAt(0) == '-';
        int answer = 0;
        for (int i = isNeg ? 1 : 0; i < s.length(); i++) {
            answer *= 10;
            answer += s.charAt(i) - '0';
        }
        return isNeg ? -answer : answer;
    }
}

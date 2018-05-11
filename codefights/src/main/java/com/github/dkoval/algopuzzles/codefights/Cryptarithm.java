package com.github.dkoval.algopuzzles.codefights;

/**
 * <a href="https://codefights.com/interview-practice/task/yM4uWYeQTHzYewW9H/description">Cryptarithm</a>
 */
public class Cryptarithm {

    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        int[] codes = letterCodes(solution);
        int x = wordToInt(crypt[0], codes);
        int y = wordToInt(crypt[1], codes);
        int z = wordToInt(crypt[2], codes);
        return (x + y) == z;
    }

    private static int[] letterCodes(char[][] solution) {
        int[] codes = new int[26];
        for (char[] letterToDigit : solution) {
            int index = letterToDigit[0] - 'A';
            int digit = letterToDigit[1] - '0';
            codes[index] = digit;
        }
        return codes;
    }

    private static int wordToInt(String word, int[] codes) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'A';
            int digit = codes[index];
            if (word.length() > 1 && i == 0 && digit == 0) {
                return -1;
            }
            result = result * 10 + digit;
        }
        return result;
    }
}

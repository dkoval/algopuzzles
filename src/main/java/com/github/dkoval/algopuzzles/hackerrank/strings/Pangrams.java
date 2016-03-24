package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/pangrams">Problem:</a>
 * Max Score: 20, Difficulty: Easy
 * <p>
 * Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence
 * "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram.
 * (Pangrams are sentences constructed by using every letter of the alphabet at least once.)
 * <p>
 * After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.
 * <p>
 * Given a sentence s, tell Roy if it is a pangram or not.
 * <p>
 * Input Format
 * <p>
 * Input consists of a string s.
 * <p>
 * Constraints
 * <p>
 * Length of ss can be at most 10^3 (1≤|s|≤10^3) and it may contain spaces, lower case and upper case letters.
 * Lower-case and upper-case instances of a letter are considered the same.
 * <p>
 * Output Format
 * <p>
 * Output a line containing pangram if s is a pangram, otherwise output not pangram.
 */
public class Pangrams {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        boolean isPangram = isPangram(input);
        System.out.println(isPangram ? "pangram" : "not pangram");
    }

    public static boolean isPangram(String input) {
        // there are 26 letters in English alphabet, thus int data type (4 bytes = 32 bits) can be used
        // to keep track of all used letters in the given sentence.
        int mask = 0b00000011_11111111_11111111_11111111;
        int used = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isWhitespace(ch)) {
                // ignore whitespaces
                continue;
            }
            int pos = Character.isLowerCase(ch) ? ch - 'a' : ch - 'A';
            used |= 1 << pos;
        }
        return used == mask;
    }
}

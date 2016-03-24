package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/gem-stones">Problem:</a>
 * Max Score: 20, Difficulty: Easy
 * <p>
 * John has discovered various rocks. Each rock is composed of various elements, and each element is represented by
 * a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock.
 * An element is called a gem-element if it occurs at least once in each of the rocks.
 * <p>
 * Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.
 * <p>
 * Input Format
 * <p>
 * The first line consists of an integer, N, the number of rocks.
 * Each of the next N lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ N ≤100
 * <br/>
 * Each composition consists of only lower-case Latin letters ('a'-'z').
 * <br/>
 * 1 ≤ length of each composition ≤ 100
 * <p>
 * Output Format
 * <p>
 * Print the number of gem-elements that are common in these rocks. If there are none, print 0.
 */
public class Gemstones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfRocks = scan.nextInt();
        scan.nextLine();
        int numOfGemElements = numOfGemElements(scan, numOfRocks);
        scan.close();
        System.out.println(numOfGemElements);
    }

    public static int numOfGemElements(Scanner scan, int numOfRocks) {
        int aggregatedRockComposition = 0xFFFFFFFF;
        for (int i = 0; i < numOfRocks; i++) {
            String rock = scan.nextLine();
            // 1-bit at position i means that there are at least 2 rocks
            // including i-th element
            aggregatedRockComposition &= rockComposition(rock);
        }
        return Integer.bitCount(aggregatedRockComposition);
    }

    private static int rockComposition(String rock) {
        // there are 26 letters in English alphabet, thus int data type (4 bytes = 32 bits) can be used
        // to keep track of all used letters in the given string.
        int composition = 0;
        for (int i = 0; i < rock.length(); i++) {
            char ch = rock.charAt(i);
            int pos = ch - 'a';
            // 1-bit at position pos denotes a used letter: a - 0, b - 1, ..., z - 25
            composition |= 1 << pos;
        }
        return composition;
    }
}

package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.hackerrank.com/challenges/weighted-uniform-string/problem">Weighted Uniform Strings</a>
 * Max Score: 20, Difficulty: Easy
 */
public class WeightedUniformStrings {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            int n = in.nextInt();
            Set<Integer> weights = allSubStringsWeights(s);
            while (n-- > 0) {
                int x = in.nextInt();
                boolean ans = hasUniformSubstringOfWeight(weights, x);
                System.out.println(ans ? "Yes" : "No");
            }
        }
    }

    static Set<Integer> allSubStringsWeights(String s) {
        Set<Integer> weights = new HashSet<>();
        int lastCharWeight = -1, subStringLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int charWeight = s.charAt(i) - 'a' + 1;
            if (charWeight == lastCharWeight) {
                subStringLength++;
            } else {
                subStringLength = 1;
                lastCharWeight = charWeight;
            }
            int subStringWeight = charWeight * subStringLength;
            weights.add(subStringWeight);
        }
        return weights;
    }

    static boolean hasUniformSubstringOfWeight(Set<Integer> weights, int x) {
        return weights.contains(x);
    }
}

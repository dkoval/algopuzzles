package com.github.dkoval.algopuzzles.firecode.level3;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to return all valid combinations of n-pairs of parentheses.
 * <p>
 * The method should return an ArrayList of strings, in which each string represents a valid combination of parentheses.
 * <p>
 * The order of the strings in the ArrayList does not matter.
 */
public class CombinationsOfParentheses {

    public static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> res = new ArrayList<>();
        if (pairs > 0) {
            doCompParenthesis(res, "", pairs, pairs);
        }
        return res;
    }

    // Good reading: http://www.programcreek.com/2014/01/leetcode-generate-parentheses-java
    private static void doCompParenthesis(List<String> res, String combination, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(combination);
        } else {
            if (open > 0) {
                doCompParenthesis(res, combination + "(", open - 1, close);
            }
            if (close > open) {
                doCompParenthesis(res, combination + ")", open, close - 1);
            }
        }
    }
}

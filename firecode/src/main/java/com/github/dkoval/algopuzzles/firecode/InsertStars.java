package com.github.dkoval.algopuzzles.firecode;

/**
 * Given a string, recursively compute a new string where the identical adjacent characters
 * in the original string are separated by a "*".
 */
public class InsertStars {

    public static String insertPairStar(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        if (s.charAt(0) == s.charAt(1)) {
            return s.substring(0, 1) + '*' + insertPairStar(s.substring(1));
        } else {
            return s.substring(0, 1) + insertPairStar(s.substring(1));
        }
    }
}

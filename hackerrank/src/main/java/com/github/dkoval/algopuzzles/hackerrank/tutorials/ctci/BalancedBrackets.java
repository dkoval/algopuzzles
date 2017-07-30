package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-balanced-brackets">Stacks: Balanced Brackets</a>
 * Max Score: 30 Difficulty: Medium
 */
public class BalancedBrackets {
    private static final Set<Character> openingBrackets;
    private static final Set<Character> closingBrackets;

    static {
        openingBrackets = new HashSet<>();
        openingBrackets.add('(');
        openingBrackets.add('[');
        openingBrackets.add('{');

        closingBrackets = new HashSet<>();
        closingBrackets.add(')');
        closingBrackets.add(']');
        closingBrackets.add('}');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }

    static boolean isBalanced(String expression) {
        Deque<Character> leftChars = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (openingBrackets.contains(ch)) {
                leftChars.push(ch);
            }
            if (closingBrackets.contains(ch)) {
                if (leftChars.isEmpty()) {
                    // unmatched closing bracket
                    return false;
                }
                if (!isMatchingPairOfBrackets(leftChars.pop(), ch)) {
                    // mismatched pair of brackets
                    return false;
                }
            }
        }
        return leftChars.isEmpty();
    }

    private static boolean isMatchingPairOfBrackets(char openingBracket, char closingBracket) {
        return (openingBracket == '(' && closingBracket == ')')
                || (openingBracket == '[' && closingBracket == ']')
                || (openingBracket == '{' && closingBracket == '}');
    }
}

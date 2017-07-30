package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-balanced-brackets">Stacks: Balanced Brackets</a>
 * Max Score: 30 Difficulty: Medium
 */
public class BalancedBrackets {
    private static final char[][] brackets = {
            {'(', ')'},
            {'[', ']'},
            {'{', '}'}
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }

    static boolean isBalanced(String expression) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isMatchingPairOfBrackets(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch) {
        for (char[] pair : brackets) {
            if (pair[0] == ch) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMatchingPairOfBrackets(char openingBracket, char closingBracket) {
        for (char[] pair : brackets) {
            if (pair[0] == openingBracket) {
                return pair[1] == closingBracket;
            }
        }
        return false;
    }
}

package com.github.dkoval.algopuzzles.codefights;

import java.util.Objects;

/**
 * <a href="https://codefights.com/interview-practice/task/tXN6wQsTknDT6bNrf">isTreeSymmetric</a>
 * Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
 */
public class IsTreeSymmetric {

    static class Tree<T> {
        T value;
        Tree<T> left;
        Tree<T> right;

        Tree(T value) {
            this.value = value;
        }
    }

    static boolean isTreeSymmetric(Tree<Integer> t) {
        if (t == null) {
            return true;
        }
        return isTreeSymmetric(t.left, t.right);
    }

    private static boolean isTreeSymmetric(Tree<Integer> left, Tree<Integer> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return Objects.equals(left.value, right.value)
                    && isTreeSymmetric(left.left, right.right)
                    && isTreeSymmetric(left.right, right.left);
        }
        return false;
    }
}

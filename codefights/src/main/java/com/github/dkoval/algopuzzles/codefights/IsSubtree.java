package com.github.dkoval.algopuzzles.codefights;

import java.util.Objects;

/**
 * <a href="https://codefights.com/interview-practice/task/mDpAJnDQkJqaYYsCg">isSubtree</a>
 * <p>
 * Given two binary trees t1 and t2, determine whether the second tree is a subtree of the first tree.
 * A subtree for vertex v in a binary tree t is a tree consisting of v and all its descendants in t.
 * Determine whether or not there is a vertex v (possibly none) in tree t1 such that a subtree for vertex v (possibly empty)
 * in t1 equals t2.
 */
public class IsSubtree {

    static class Tree<T> {
        T value;
        Tree<T> left;
        Tree<T> right;

        Tree(T value, Tree<T> left, Tree<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Tree(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "value=" + value +
                    ", left=" + (left != null ? left.value + "..." : "null") +
                    ", right=" + (right != null ? right.value + "..." : "null") +
                    '}';
        }
    }

    static boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (equalTrees(t1, t2)) {
            return true;
        }
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    private static boolean equalTrees(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return Objects.equals(t1.value, t2.value)
                && equalTrees(t1.left, t2.left)
                && equalTrees(t1.right, t2.right);
    }
}

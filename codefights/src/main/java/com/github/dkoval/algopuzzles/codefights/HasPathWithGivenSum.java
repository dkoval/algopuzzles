package com.github.dkoval.algopuzzles.codefights;

/**
 * <a href="https://codefights.com/interview-practice/task/TG4tEMPnAc3PnzRCs">hasPathWithGivenSum</a>
 * Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that
 * the sum of vertex values equals s.
 */
public class HasPathWithGivenSum {

    static class Tree<T> {
        T value;
        Tree<T> left;
        Tree<T> right;

        Tree(T value) {
            this.value = value;
        }
    }

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if (t == null) {
            return s == 0;
        }
        if (t.left == null && t.right == null) {
            return s == t.value;
        }
        int curSum = s - t.value;
        return (t.left != null && hasPathWithGivenSum(t.left, curSum)) || (t.right != null && hasPathWithGivenSum(t.right, curSum));
    }
}

package com.github.dkoval.algopuzzles.ctci.ch04TreesAndGraphs;

/**
 * Q4.2 Minimal Tree: Given a sorted (increasing order) array with unique elements, write an
 * algorithm to create a binary search tree with a minimal height.
 */
public class Q02MinimalTree {

    public static class TreeNode<T extends Comparable<T>> {
        private final T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }

        public T data() {
            return data;
        }

        public TreeNode<T> left() {
            return left;
        }

        public void left(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> right() {
            return right;
        }

        public void right(TreeNode<T> right) {
            this.right = right;
        }
    }

    public static <T extends Comparable<T>> TreeNode<T> createMinBST(T elems[]) {
        return createMinBST(elems, 0, elems.length - 1);
    }

    private static <T extends Comparable<T>> TreeNode<T> createMinBST(T elems[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode<T> root = new TreeNode<>(elems[mid]);
        root.left(createMinBST(elems, start, mid - 1));
        root.right(createMinBST(elems, mid + 1, end));
        return root;
    }
}

package com.github.dkoval.algopuzzles.codefights;

/**
 * <a href="https://codefights.com/interview-practice/task/jAKLMWLu8ynBhYsv6">kthSmallestInBST</a>
 * Given a binary search tree t, find the kth smallest element in it.
 * <p>
 * Solution should have only one BST traversal and O(1) extra space complexity.
 */
public class KthSmallestInBST {

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

    static int kthSmallestInBST(Tree<Integer> t, int k) {
        int count = 0;
        int smallest = Integer.MIN_VALUE;
        Tree<Integer> curr = t;
        while (curr != null) {
            if (curr.left == null) {
                if (++count == k) {
                    smallest = curr.value;
                }
                curr = curr.right;
            } else {
                // create links to inorder successor
                Tree<Integer> prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    // link to inorder successor
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // revert the changes
                    prev.right = null;
                    if (++count == k) {
                        smallest = curr.value;
                    }
                    curr = curr.right;
                }
            }
        }
        return smallest;
    }
}

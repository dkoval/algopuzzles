package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-is-binary-search-tree">Trees: Is This a Binary Search Tree</a>
 * Max Score: 30 Difficulty: Medium
 */
public class IsThisBinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static boolean checkBST(Node root) {
        return doCheckBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean doCheckBST(Node root, int loBoundary, int hiBoundary) {
        if (root == null) {
           return true;
        }
        if (root.data <= loBoundary || root.data >= hiBoundary) {
            return false;
        }
        return doCheckBST(root.left, loBoundary, root.data) && doCheckBST(root.right, root.data, hiBoundary);
    }
}

package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a binary tree, write a recursive method to return the maximum element.
 */
public class FindMaxInBinaryTree {

    public static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }
}

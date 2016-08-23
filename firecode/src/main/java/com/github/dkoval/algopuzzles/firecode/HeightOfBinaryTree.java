package com.github.dkoval.algopuzzles.firecode;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a binary tree, write a method to find its height recursively. An empty tree has a height of 0.
 */
public class HeightOfBinaryTree {

    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}

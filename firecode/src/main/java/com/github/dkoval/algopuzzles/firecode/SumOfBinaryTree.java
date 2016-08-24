package com.github.dkoval.algopuzzles.firecode;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a binary tree, write a method to find and return the sum of all the elements using recursion.
 * For an empty tree the sum is 0.
 */
public class SumOfBinaryTree {

    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }
}

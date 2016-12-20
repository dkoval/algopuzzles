package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a Binary Search Tree, return the node with the minimum data.
 */
public class FindMinBSTNode {

    public static TreeNode findMin(TreeNode root) {
        // In a BST, the left most node is the one with lowest value.
        if (root == null) {
            return null;
        }
        TreeNode min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }
}

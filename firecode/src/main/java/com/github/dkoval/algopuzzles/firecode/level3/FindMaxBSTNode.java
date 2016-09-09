package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a Binary Search Tree, return the node with the maximum data.
 */
public class FindMaxBSTNode {

    public static TreeNode findMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        // find the rightmost node of the tree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
}

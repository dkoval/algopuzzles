package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Write a function to convert a binary tree into its mirror image and return the root node of the mirrored tree.
 */
public class MirrorBinaryTree {

    public static TreeNode mirror(TreeNode root) {
        if (root != null) {
            TreeNode left = mirror(root.left);
            TreeNode right = mirror(root.right);
            // swap left and right subtrees
            root.left = right;
            root.right = left;
        }
        return root;
    }
}

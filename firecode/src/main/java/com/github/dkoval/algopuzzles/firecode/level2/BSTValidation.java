package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given the root node of a Binary Tree, determine if it is a Binary Search Tree.
 */
public class BSTValidation {

    public static boolean validateBST(TreeNode root) {
        return (root == null) || doValidateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean doValidateBST(TreeNode root, int min, int max) {
        if (root.data < min || root.data >= max) {
            return false;
        }
        if (root.left != null && !doValidateBST(root.left, min, root.data)) {
            return false;
        }
        return !(root.right != null && !doValidateBST(root.right, root.data, max));
    }

    private static boolean doValidateBSTOptmized(TreeNode root, int min, int max) {
        return (root.data >= min && root.data <= max)
                && (root.left == null || doValidateBST(root.left, min, root.data))
                && (root.right == null || doValidateBST(root.right, root.data, max));
    }
}

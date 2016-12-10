package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given two binary trees, determine if they are identical. If they are, return true otherwise return false.
 */
public class AreBinaryTressIdentical {

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return (root2 == null);
        }
        if (root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}

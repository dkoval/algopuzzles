package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a binary tree, write a method to return its size.
 * The size of a tree is the number of nodes it contains.
 */
public class SizeOfBinaryTree {

    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
}

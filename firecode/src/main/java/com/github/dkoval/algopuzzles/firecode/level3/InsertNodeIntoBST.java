package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Implement a method to insert a node into a Binary Search Tree. Return the root of the modified tree.
 */
public class InsertNodeIntoBST {

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data, null, null);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}

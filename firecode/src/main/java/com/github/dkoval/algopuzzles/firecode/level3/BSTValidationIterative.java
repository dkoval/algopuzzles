package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a Binary Tree, write a method to iteratively determine if it is a Binary Search Tree.
 * <p>
 * A BST must satisfy the following conditions:
 * The left subtree of a node contains nodes with data < its data.
 * The right subtree of a node contains  nodes data > its data.
 * A node's left and right subtrees follow the above two conditions.
 */
public class BSTValidationIterative {

    /**
     * TreeNode and it's boundaries.
     */
    private static class BoundedTreeNode {
        final TreeNode self;
        final int left;
        final int right;

        BoundedTreeNode(TreeNode self, int left, int right) {
            this.self = self;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<BoundedTreeNode> q = new LinkedList<>();
        q.add(new BoundedTreeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!q.isEmpty()) {
            BoundedTreeNode n = q.remove();
            if (n.self.data <= n.left || n.self.data >= n.right) {
                return false;
            }
            if (n.self.left != null) {
                q.add(new BoundedTreeNode(n.self.left, n.left, n.self.data));
            }
            if (n.self.right != null) {
                q.add(new BoundedTreeNode(n.self.right, n.self.data, n.right));
            }
        }
        return true;
    }
}

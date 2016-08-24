package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a method to find and return the node with data = the input data.
 * Do not use recursion.
 */
public class FindNodeInBinaryTreeWithoutRecursion {

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n.data == val) {
                return n;
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return null;
    }
}

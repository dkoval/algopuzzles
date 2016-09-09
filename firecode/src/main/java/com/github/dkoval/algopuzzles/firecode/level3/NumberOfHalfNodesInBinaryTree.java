package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function to find the total number of half nodes in a binary tree.
 * A half node is a node which has exactly one child node. If there are no half nodes, return 0.
 */
public class NumberOfHalfNodesInBinaryTree {

    public static int numberOfHalfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if ((n.left == null && n.right != null) || (n.left != null && n.right == null)) {
                count++;
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return count;
    }
}

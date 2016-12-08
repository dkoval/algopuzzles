package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function to iteratively determine the total number of "full nodes" in a binary tree.
 * A full node contains left and right child nodes. If there are no full nodes, return 0.
 */
public class NumberOfFullNodesInBinaryTree {

    public static int numberOfFullNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null && node.right != null) {
                count++;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return count;
    }
}

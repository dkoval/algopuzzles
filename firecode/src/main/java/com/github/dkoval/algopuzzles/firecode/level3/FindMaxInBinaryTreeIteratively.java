package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Iteratively, find the Max Element in a Given Binary Tree.
 */
public class FindMaxInBinaryTreeIteratively {

    public static int findMaxItr(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return max;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            max = Math.max(max, node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return max;
    }
}

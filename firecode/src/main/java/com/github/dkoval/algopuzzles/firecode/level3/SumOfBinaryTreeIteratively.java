package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a method to find and return the sum of all nodes of the tree iteratively.
 */
public class SumOfBinaryTreeIteratively {

    public static int sumItr(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            sum += node.data;
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return sum;
    }
}

package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a method to find and return its deepest node. Return null for an empty tree.
 */
public class DeepestNode {

    public static TreeNode findDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode deepest = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            deepest = q.remove();
            if (deepest.left != null) {
                q.add(deepest.left);
            }
            if (deepest.right != null) {
                q.add(deepest.right);
            }
        }
        return deepest;
    }
}

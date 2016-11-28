package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a method to perform a levelorder traversal and return
 * an ArrayList of integers containing the data of the visited nodes in the correct order.
 */
public class LevelorderTraversal {

    public static ArrayList<Integer> levelorder(TreeNode root) {
        ArrayList<Integer> order = new ArrayList<>();
        if (root == null) {
            return order;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            order.add(node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return order;
    }
}

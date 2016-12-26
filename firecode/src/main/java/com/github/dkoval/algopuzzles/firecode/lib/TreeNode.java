package com.github.dkoval.algopuzzles.firecode.lib;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this(data, null, null);
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> nodes = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            nodes.add(n.data);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return nodes;
    }
}

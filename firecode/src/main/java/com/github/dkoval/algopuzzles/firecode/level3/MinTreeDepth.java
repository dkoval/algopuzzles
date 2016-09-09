package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a non-recursive method minTreeDepth that takes in the root node of a Binary Tree and
 * returns the minimum depth of the tree. The minimum depth is defined as the least number of
 * node traversals needed to reach a leaf from the root node.
 * Your method should run in linear O(n) time and use at max O(n) space.
 */
public class MinTreeDepth {

    public static int minTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            TreeNode t = currLevel.remove();
            if (t.left == null && t.right == null) {
                return depth;
            }
            if (t.left != null) {
                nextLevel.add(t.left);
            }
            if (t.right != null) {
                nextLevel.add(t.right);
            }
            if (currLevel.isEmpty()) {
                currLevel = nextLevel;
                nextLevel = new LinkedList<>();
                depth++;
            }
        }
        return depth;
    }
}

package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.level2.HeightOfBinaryTree;
import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary search tree and an integer k, implement a method to find and return the kth smallest node.
 */
public class FindKthSmallestNodeInBST {

    public static TreeNode findKthSmallestRecursive(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        int leftTreeHeight = 0;
        if (root.left != null) {
            leftTreeHeight = HeightOfBinaryTree.findHeight(root.left);
        }
        if (leftTreeHeight == k - 1) {
            return root;
        } else if (leftTreeHeight >= k) {
            return findKthSmallestRecursive(root.left, k);
        } else {
            return findKthSmallestRecursive(root.right, k - leftTreeHeight - 1);
        }
    }

    // Good reading: http://www.programcreek.com/2014/07/leetcode-kth-smallest-element-in-a-bst-java/
    public static TreeNode findKthSmallestIterative(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode res = null;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode n = stack.pop();
                k--;
                if (k == 0) {
                    res = n;
                }
                p = n.right;
            }
        }
        return res;
    }
}

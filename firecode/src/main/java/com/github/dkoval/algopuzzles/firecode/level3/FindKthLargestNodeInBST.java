package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.level2.SizeOfBinaryTree;
import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a Binary Search Tree and an integer k, implement a method to find and return its kth largest node.
 */
public class FindKthLargestNodeInBST {

    public static TreeNode findKthLargestRecursive(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        // The key here is to find the size of the right subtree at each node.
        // If the size + 1 is equal to k, return that node.
        int rightSubtreeSize = 0;
        if (root.right != null) {
            rightSubtreeSize = SizeOfBinaryTree.size(root.right);
        }
        if (rightSubtreeSize == k - 1) {
            return root;
        }
        if (rightSubtreeSize >= k) {
            return findKthLargestRecursive(root.right, k);
        } else {
            return findKthLargestRecursive(root.left, k - rightSubtreeSize - 1);
        }
    }

    public static TreeNode findKthLargestIterative(TreeNode root, Integer k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                TreeNode n = stack.pop();
                if (--k == 0) {
                    return n;
                }
                p = n.left;
            }
        }
        return null;
    }
}

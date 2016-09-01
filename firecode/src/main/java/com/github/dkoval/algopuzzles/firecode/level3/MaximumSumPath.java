package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a binary tree consisting of nodes with positive integer values, write a method - maxSumPath
 * that returns the maximum sum of data values obtained by traversing nodes along a path between any 2 nodes
 * of the tree. The path must originate and terminate at 2 different nodes of the tree, and the maximum sum
 * is obtained by summing all the data values of the nodes traversed along this path.
 */
public class MaximumSumPath {

    public static int maxSumPath(TreeNode root) {
        int[] maxSumHolder = {0};
        doMaxSumPath(root, maxSumHolder);
        return maxSumHolder[0];
    }

    private static int doMaxSumPath(TreeNode root, int[] maxSumHolder) {
        //  a binary tree consists of nodes with positive integer values
        if (root == null) {
            return 0;
        }
        int leftSum = doMaxSumPath(root.left, maxSumHolder);
        int rightSum = doMaxSumPath(root.right, maxSumHolder);
        // the return value of this node that will be fed to the calling node
        int curr = Math.max(leftSum, rightSum) + root.data;
        // maximum sum path obtained till this point
        maxSumHolder[0] = Math.max(maxSumHolder[0], leftSum + root.data + rightSum);
        return curr;
    }
}

package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given the root of a Binary Tree  and an integer that represents the data value of a TreeNode present in the tree,
 * write a method - pathLengthFromRoot that returns the distance between the root and that node.
 * You can assume that the given key exists in the tree. The distance is defined as the minimum number of nodes that
 * must be traversed to reach the target node.
 */
public class DistanceOfNodeFromRoot {

    public static int pathLengthFromRoot(TreeNode root, int n1) {
        if (root == null) {
            return 0;
        }
        if (root.data == n1) {
            return 1;
        }
        // found in the left subtree
        int leftPathLength = pathLengthFromRoot(root.left, n1);
        if (leftPathLength > 0) {
            return 1 + leftPathLength;
        }
        // found in the right subtree
        int rightPathLength = pathLengthFromRoot(root.right, n1);
        if (rightPathLength > 0) {
            return 1 + rightPathLength;
        }
        // not found
        return -1;
    }
}

package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.level2.HeightOfBinaryTree;
import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a BST, write a function to return its diameter.
 * The diameter of a Binary Tree is defined as the "Number of nodes on the longest path between two leaf nodes".
 */
public class FindDiameterOfBST {

    // Good reading: http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Naive approach O(N^2):
        // Diameter = Max(Diameter of left sub-tree, Diameter of right sub-tree, Longest path between two nodes which passes through the root)
        return Math.max(
                Math.max(diameter(root.left), diameter(root.right)),
                HeightOfBinaryTree.findHeight(root.left) + HeightOfBinaryTree.findHeight(root.right) + 1);
    }
}

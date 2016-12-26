package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.level2.HeightOfBinaryTree;
import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

/**
 * Given a BST, write a function to return its diameter.
 * The diameter of a Binary Tree is defined as the "Number of nodes on the longest path between two leaf nodes".
 */
public class FindDiameterOfBST {

    // Good reading: http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
    public static int diameterNaive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Naive approach O(N^2):
        // Diameter = Max(Diameter of left sub-tree, Diameter of right sub-tree, Longest path between two nodes which passes through the root)
        return Math.max(
                Math.max(diameterNaive(root.left), diameterNaive(root.right)),
                HeightOfBinaryTree.findHeight(root.left) + HeightOfBinaryTree.findHeight(root.right) + 1);
    }

    public static int diameterImproved(TreeNode root) {
        return doDiameter(root).diameter;
    }

    private static DiameterAndHeight doDiameter(TreeNode root) {
        if (root == null) {
            return DiameterAndHeight.ZERO;
        }

        DiameterAndHeight leftDH = doDiameter(root.left);
        DiameterAndHeight rightDH = doDiameter(root.right);

        // Improvement: find the height of tree and diameter in the same iteration
        int diameter = Math.max(
                Math.max(leftDH.diameter, rightDH.diameter),
                leftDH.height + rightDH.height + 1);
        int height = Math.max(leftDH.height, rightDH.height) + 1;
        return new DiameterAndHeight(diameter, height);
    }

    final static class DiameterAndHeight {
        final int diameter;
        final int height;

        static final DiameterAndHeight ZERO = new DiameterAndHeight(0, 0);

        DiameterAndHeight(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}

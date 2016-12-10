package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree's root node, an empty ArrayList and an integer nodeData, write a method that finds
 * a target node - N with data = nodeData and populates the ArrayList with the data of the ancestor nodes of N -
 * added from the bottom - up.
 */
public class FillInAncestorsOfNodeInBinaryTree {
    public ArrayList<Integer> ancestorsList = new ArrayList<>();

    public boolean printAncestors(TreeNode root, int nodeData) {
        if (root == null) {
            return false;
        }
        if (root.data == nodeData) {
            return true;
        }
        if (printAncestors(root.left, nodeData) || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.data);
            return true;
        }
        return false;
    }
}

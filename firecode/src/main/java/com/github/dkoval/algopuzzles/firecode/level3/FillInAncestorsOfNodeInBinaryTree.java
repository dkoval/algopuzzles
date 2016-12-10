package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static List<Integer> printAncestorsStateless(TreeNode root, int nodeData) {
        List<Integer> res = new LinkedList<>();
        doPrintAncestorsStateless(root, nodeData, res);
        return res;
    }

    private static boolean doPrintAncestorsStateless(TreeNode root, int nodeData, List<Integer> res) {
        if (root == null) {
            return false;
        }
        if (root.data == nodeData) {
            return true;
        }
        if (doPrintAncestorsStateless(root.left, nodeData, res) || doPrintAncestorsStateless(root.right, nodeData, res)) {
            res.add(root.data);
            return true;
        }
        return false;
    }
}
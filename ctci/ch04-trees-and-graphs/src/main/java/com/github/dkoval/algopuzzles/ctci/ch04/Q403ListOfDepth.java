package com.github.dkoval.algopuzzles.ctci.ch04;

import com.github.dkoval.algopuzzles.ctci.lib.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Q4.3 Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Q403ListOfDepth {

    public static <T extends Comparable<T>> List<List<TreeNode<T>>> createNodeDepthTable(TreeNode<T> root) {
        List<List<TreeNode<T>>> result = new LinkedList<>();
        List<TreeNode<T>> currentLevel = new LinkedList<>();
        if (root != null) {
            currentLevel.add(root);
        }
        // go to next i + 1 level
        while (!currentLevel.isEmpty()) {
            result.add(currentLevel);
            List<TreeNode<T>> parentLevel = currentLevel;
            currentLevel = new LinkedList<>();
            for (TreeNode<T> parent : parentLevel) {
                if (parent.getLeft() != null) {
                    currentLevel.add(parent.getLeft());
                }
                if (parent.getRight() != null) {
                    currentLevel.add(parent.getRight());
                }
            }
        }
        return result;
    }
}

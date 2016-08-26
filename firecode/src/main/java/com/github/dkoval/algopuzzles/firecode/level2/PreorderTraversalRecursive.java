package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree, write a method to recursively traverse the tree in the preorder manner.
 * Mark a node as visited by adding its data to the list - Arraylist <Integer> preorderedList.
 */
public class PreorderTraversalRecursive {
    final ArrayList<Integer> preorderedList = new ArrayList<>();

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorderedList.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }
}

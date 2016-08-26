package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Given a binary tree, write a method to iteratively traverse the tree in the preorder manner.
 * Mark a node as visited by adding its data to a list - Arraylist<Integer> preorderedList.
 * Return this list.
 */
public class PreorderTraversalIterative {

    public static ArrayList<Integer> preorderItr(TreeNode root) {
        ArrayList<Integer> preorderedList = new ArrayList<>();
        if (root == null) {
            return preorderedList;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            preorderedList.add(top.data);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return preorderedList;
    }
}

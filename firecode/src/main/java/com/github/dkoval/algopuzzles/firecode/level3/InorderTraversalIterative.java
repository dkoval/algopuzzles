package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary tree, write a method to perform the inorder traversal iteratively.
 * Append the data of each node visited to an ArrayList.
 * Return an empty Arraylist in the case of an empty tree.
 */
public class InorderTraversalIterative {

    public static ArrayList<Integer> inorderItr(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        if (root == null) {
            return inorderList;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (true) {
            // first node to be visited will be the left one
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                curr = stack.pop();
                inorderList.add(curr.data);
                // jump to the right node and repeat the whole procedure once again
                curr = curr.right;
            }
        }
        return inorderList;
    }
}

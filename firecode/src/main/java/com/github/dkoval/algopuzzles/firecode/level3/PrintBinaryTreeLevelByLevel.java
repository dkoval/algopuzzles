package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a method to print the tree level by level.
 */
public class PrintBinaryTreeLevelByLevel {

    public static ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelByLevelData = new ArrayList<>();
        if (root == null) {
            return levelByLevelData;
        }
        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            ArrayList<Integer> currLevelData = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.remove();
                currLevelData.add(node.data);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            levelByLevelData.add(currLevelData);
            currLevel = nextLevel;
        }
        return levelByLevelData;
    }
}

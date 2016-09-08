package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a String that represents a Binary Tree, write a method - decompressTree that decompresses that tree
 * (reconstructs the tree) and returns the root TreeNode. The compression algorithm included traversing the tree
 * level by level, from the left to the right. The TreeNode's data values were appended to the String, delimited by commas.
 * Also, null TreeNodes were denoted by appending an asterisk - *. The input String denotes the structure of a
 * Full Binary Tree - i.e. a tree that is structurally balanced. However, the reconstructed tree may not be a full tree
 * as the String included * characters, which represent null TreeNodes.
 * <p>
 * Note:
 * You can assume that if a Binary Tree contains k levels, the compressed String will contain 2^k-1 elements -
 * either numbers or *.
 */
public class FullTreeDecompression {

    public static TreeNode decompressTree(String str) {
        if (str == null || str.isEmpty() || str.startsWith("*")) {
            return null;
        }
        Queue<Integer> availableNums = mapTokens(str.split(","));
        TreeNode root = new TreeNode(availableNums.remove(), null, null);
        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);
        while (!availableNums.isEmpty()) {
            Integer leftNum = availableNums.remove();
            Integer rightNum = availableNums.remove();
            TreeNode p = parents.remove();
            if (p != null) {
                p.left = (leftNum != null) ? new TreeNode(leftNum, null, null) : null;
                p.right = (rightNum != null) ? new TreeNode(rightNum, null, null) : null;
                parents.add(p.left);
                parents.add(p.right);
            }
        }
        return root;
    }

    private static Queue<Integer> mapTokens(String[] tokens) {
        Queue<Integer> res = new LinkedList<>();
        for (String token : tokens) {
            Integer num = "*".equals(token) ? null : Integer.parseInt(token);
            res.add(num);
        }
        return res;
    }
}

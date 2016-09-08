package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        List<Integer> seq = mapTokens(str.split(","));
        int i = 0;
        TreeNode root = (seq.get(i) != null) ? new TreeNode(seq.get(i), null, null) : null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (i < seq.size() - 1) {
            TreeNode n = q.remove();
            if (n != null) {
                Integer leftData = seq.get(i + 1);
                Integer rightData = seq.get(i + 2);
                n.left = (leftData != null) ? new TreeNode(leftData, null, null) : null;
                n.right = (rightData != null) ? new TreeNode(rightData, null, null) : null;
                q.add(n.left);
                q.add(n.right);
            }
            i += 2;
        }
        return root;
    }

    private static List<Integer> mapTokens(String[] tokens) {
        List<Integer> res = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            Integer num = "*".equals(token) ? null : Integer.parseInt(token);
            res.add(num);
        }
        return res;
    }
}

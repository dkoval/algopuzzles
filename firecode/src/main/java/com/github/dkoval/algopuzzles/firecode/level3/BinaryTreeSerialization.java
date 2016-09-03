package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * You're given the root node of a binary tree - TreeNode root in the method serializeTree.
 * This method should serialize the binary tree and output a String str, which is then used as an input parameter
 * for the method restoreTree. restoreTree should create a Binary Tree that is structurally identical to the one
 * you serialized and return the root node of the tree.
 * <p>
 * Your task is to fill in the logic for these 2 methods.
 * <p>
 * Feel free to use any notation you prefer when serializing the binary tree.
 * The choice of traversal algorithm is also open - but try and limit the time complexity of both methods to O(n).
 */
public class BinaryTreeSerialization {

    public static String serializeTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        doSerializeTree(root, buf);
        // ignore last comma
        return buf.substring(0, buf.length() - 1);
    }

    private static void doSerializeTree(TreeNode root, StringBuilder buf) {
        if (root == null) {
            buf.append("#,");
        } else {
            // pre-order traversal
            buf.append(root.data).append(",");
            doSerializeTree(root.left, buf);
            doSerializeTree(root.right, buf);
        }
    }

    public static TreeNode restoreTree(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return doRestoreTree(new LinkedList<>(Arrays.asList(str.split(","))));
    }

    private static TreeNode doRestoreTree(LinkedList<String> tokens) {
        if (tokens.isEmpty()) {
            return null;
        }
        String token = tokens.removeFirst();
        if ("#".equals(token)) {
            return null;
        }
        // pre-order traversal
        TreeNode node = new TreeNode(Integer.parseInt(token), null, null);
        node.left = doRestoreTree(tokens);
        node.right = doRestoreTree(tokens);
        return node;
    }
}

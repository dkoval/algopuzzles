package com.github.dkoval.algopuzzles.codefights;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://codefights.com/interview-practice/task/AaWaYxi8gjtbqgp2M">restoreBinaryTree</a>
 * <p>
 * Given the inorder and preorder traversals of a binary tree t, but not t itself, restore t and return it.
 */
public class RestoreBinaryTree {

    static class Tree<T> {
        T value;
        Tree<T> left;
        Tree<T> right;

        Tree(T value, Tree<T> left, Tree<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Tree(T value) {
            this.value = value;
        }

        static boolean equalTrees(Tree<Integer> t1, Tree<Integer> t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            return Objects.equals(t1.value, t2.value)
                    && equalTrees(t1.left, t2.left)
                    && equalTrees(t1.right, t2.right);
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "value=" + value +
                    ", left=" + (left != null ? left.value + "..." : "null") +
                    ", right=" + (right != null ? right.value + "..." : "null") +
                    '}';
        }
    }

    // Runtime complexity: O(n^2)
    static Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
        if (inorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int leftSubtreeLength = IntStream.range(0, inorder.length)
                .filter(i -> inorder[i] == root)
                .findFirst().orElse(-1);

        Tree<Integer> node = new Tree<>(root);
        node.left = restoreBinaryTree(
                Arrays.copyOfRange(inorder, 0, leftSubtreeLength),
                Arrays.copyOfRange(preorder, 1, leftSubtreeLength + 1));

        node.right = restoreBinaryTree(
                Arrays.copyOfRange(inorder, leftSubtreeLength + 1, inorder.length),
                Arrays.copyOfRange(preorder, leftSubtreeLength + 1, inorder.length));

        return node;
    }

    static Tree<Integer> restoreBinaryTreeImproved(int[] inorder, int[] preorder) {
        Map<Integer, Integer> inorderValuesIndex = IntStream.range(0, inorder.length)
                .boxed()
                .collect(Collectors.toMap(i -> inorder[i], Function.identity()));
        return doRestoreBinaryTreeImproved(inorder, preorder, inorderValuesIndex);
    }

    private static Tree<Integer> doRestoreBinaryTreeImproved(int[] inorder, int[] preorder,
                                                             Map<Integer, Integer> inorderValuesIndex) {
        if (inorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int leftSubtreeLength = inorderValuesIndex.get(root);

        Tree<Integer> node = new Tree<>(root);
        node.left = restoreBinaryTree(
                Arrays.copyOfRange(inorder, 0, leftSubtreeLength),
                Arrays.copyOfRange(preorder, 1, leftSubtreeLength + 1));

        node.right = restoreBinaryTree(
                Arrays.copyOfRange(inorder, leftSubtreeLength + 1, inorder.length),
                Arrays.copyOfRange(preorder, leftSubtreeLength + 1, inorder.length));

        return node;
    }
}

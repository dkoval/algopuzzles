package com.github.dkoval.algopuzzles.ctci.ch04;

import com.github.dkoval.algopuzzles.ctci.lib.TreeNode;

/**
 * Q4.2 Minimal Tree: Given a sorted (increasing order) array with unique elements, write an
 * algorithm to create a binary search tree with a minimal height.
 */
public class Q402MinimalTree {

    public static <T extends Comparable<T>> TreeNode<T> createMinBST(T elems[]) {
        return createMinBST(elems, 0, elems.length - 1);
    }

    private static <T extends Comparable<T>> TreeNode<T> createMinBST(T elems[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode<T> root = new TreeNode<>(elems[mid]);
        root.left(createMinBST(elems, start, mid - 1));
        root.right(createMinBST(elems, mid + 1, end));
        return root;
    }
}

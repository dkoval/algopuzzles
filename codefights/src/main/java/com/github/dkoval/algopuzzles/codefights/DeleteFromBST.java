package com.github.dkoval.algopuzzles.codefights;

import java.util.Objects;

/**
 * <a href="https://app.codesignal.com/interview-practice/task/oZXs4td52fsdWC9kR">deleteFromBST</a>
 */
public class DeleteFromBST {

    static class Tree<T> {
        T value;
        Tree<T> left;
        Tree<T> right;

        Tree(T value, Tree<T> left, Tree<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "value=" + value +
                    ", left=" + (left != null ? left.value + "..." : "null") +
                    ", right=" + (right != null ? right.value + "..." : "null") +
                    '}';
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
    }

    static Tree<Integer> deleteFromBST(Tree<Integer> tree, int[] queries) {
        for (int query : queries) {
            tree = doDeleteFromBST(tree, query);
        }
        return tree;
    }

    private static Tree<Integer> doDeleteFromBST(Tree<Integer> root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            if (root.left == null) {
                return root.right;
            } else {
                Tree<Integer> m = findMax(root.left);
                m.left = delMax(root.left);
                m.right = root.right;
                return m;
            }
        } else {
            root.left = doDeleteFromBST(root.left, value);
            root.right = doDeleteFromBST(root.right, value);
        }
        return root;
    }

    private static Tree<Integer> findMax(Tree<Integer> root) {
        Tree<Integer> x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    private static Tree<Integer> delMax(Tree<Integer> root) {
        Tree<Integer> prev = null;
        Tree<Integer> curr = root;
        while (curr.right != null) {
            prev = curr;
            curr = curr.right;
        }
        if (curr != root) {
            prev.right = curr.left;
            return root;
        }
        return curr.left;
    }
}

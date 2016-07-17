package com.github.dkoval.algopuzzles.ctci.lib;

/**
 * Represents a generic tree node.
 */
public class TreeNode<T extends Comparable<T>> {
    private final T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public T data() {
        return data;
    }

    public TreeNode<T> left() {
        return left;
    }

    public void left(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> right() {
        return right;
    }

    public void right(TreeNode<T> right) {
        this.right = right;
    }
}

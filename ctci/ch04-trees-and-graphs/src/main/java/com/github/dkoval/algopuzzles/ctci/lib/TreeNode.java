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

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> setLeft(TreeNode<T> left) {
        this.left = left;
        return this;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public TreeNode<T> setRight(TreeNode<T> right) {
        this.right = right;
        return this;
    }
}

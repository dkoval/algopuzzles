package com.github.dkoval.algopuzzles.epi.ch7.lists;

import java.util.Objects;

/**
 * EPI, Problem 7.1 p.63: Write a function that takes L and F, and returns the merge of L and F.
 * Your code should use O(1) additional storage - it should reuse the node from the lists provided as input.
 * The only field you can change in a node is next.
 */
public class MergeTwoSortedLists {

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node<?> that = (Node<?>) obj;
            return Objects.equals(data, that.data)
                    && Objects.equals(next, that.next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static <T extends Comparable<T>> Node<T> solution(Node<T> L, Node<T> F) {
        // merge(null, F) = F
        if (L == null) {
            return F;
        }

        // merge(L, null) = L
        if (F == null) {
            return L;
        }

        // merged list M
        Node<T> M = new Node<>(null, null);

        // iterators over L, F and merged M lists
        Node<T> lit = L;
        Node<T> fit = F;
        Node<T> mit = M;

        while (lit != null && fit != null) {
            if (lit.data.compareTo(fit.data) < 0) {
                mit.next = lit;
                lit = lit.next;
            } else {
                mit.next = fit;
                fit = fit.next;
            }
            mit = mit.next;
        }

        // append the remaining nodes of L
        if (lit != null) {
            mit.next = lit;
        }

        // append the remaining nodes of F
        if (fit != null) {
            mit.next = fit;
        }

        // skip the initial fake element
        return M.next;
    }
}

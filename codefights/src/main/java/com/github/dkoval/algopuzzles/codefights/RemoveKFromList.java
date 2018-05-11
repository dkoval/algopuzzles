package com.github.dkoval.algopuzzles.codefights;

/**
 * <a href="https://codefights.com/interview-practice/task/gX7NXPBrYThXZuanm">removeKFromList</a>
 * Given a singly linked list of integers l and an integer k, remove all elements from list l that have
 * a value equal to k.
 */
public class RemoveKFromList {

    static class ListNode<T> {
        T value;
        ListNode<T> next;

        ListNode(T x) {
            value = x;
        }
    }

    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> curr = l, prev = null;
        while (curr != null) {
            if (curr.value == k) {
                if (prev == null) {
                    // Fix beginning pointer
                    l = curr.next;
                } else {
                    // Fix previous node's next to skip over the removed node
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return l;
    }
}

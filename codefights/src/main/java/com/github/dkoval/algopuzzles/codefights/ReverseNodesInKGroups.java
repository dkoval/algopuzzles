package com.github.dkoval.algopuzzles.codefights;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://codefights.com/interview-practice/task/XP2Wn9pwZW6hvqH67">reverseNodesInKGroups</a>
 * Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer
 * that is less than or equal to the length of l. If the number of nodes in the linked list is not a multiple of k,
 * then the nodes that are left out at the end should remain as-is.
 * <p/>
 * Solution should have O(n) time complexity, where n is the number of element in l, and O(1) additional space complexity.
 */
public class ReverseNodesInKGroups {

    static class ListNode<T> {
        T value;
        ListNode<T> next;

        ListNode(T x) {
            value = x;
        }

        ListNode(T x, ListNode<T> next) {
            this(x);
            this.next = next;
        }

        List<T> values() {
            ListNode<T> curr = this;
            List<T> values = new LinkedList<>();
            while (curr != null) {
                values.add(curr.value);
                curr = curr.next;
            }
            return values;
        }

        @Override
        public String toString() {
            return '{' +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    static ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if (l == null || k == 1) {
            return l;
        }
        ListNode<Integer> dummy = new ListNode<>(0);
        dummy.next = l;
        ListNode<Integer> curr = l, prev = dummy;
        int count = 0;
        while (curr != null) {
            count++;
            if (count % k == 0) {
                prev = reverseSubList(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private static ListNode<Integer> reverseSubList(ListNode<Integer> before, ListNode<Integer> after) {
        ListNode<Integer> head = before.next, curr = head, prev = null;
        while (curr != after) {
            ListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        before.next = prev;
        head.next = after;
        return head;
    }
}

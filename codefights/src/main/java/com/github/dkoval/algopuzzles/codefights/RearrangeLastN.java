package com.github.dkoval.algopuzzles.codefights;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://codefights.com/interview-practice/task/5vcioHMkhGqkaQQYt">rearrangeLastN</a>
 * Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning
 * of the linked list. Solve this task in O(list size) time using O(1) additional space.
 */
public class RearrangeLastN {

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

    static ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        if (l == null || n == 0) {
            return l;
        }
        l = reverseSubList(l, null);
        // go to the n-th node
        ListNode<Integer> curr = l;
        while (--n > 0) {
            curr = curr.next;
        }
        ListNode<Integer> split = curr.next;
        ListNode<Integer> left = reverseSubList(l, split);
        // at this point, `l` points to the last node of the `left` sublist
        l.next = reverseSubList(split, null);
        return left;
    }

    private static ListNode<Integer> reverseSubList(ListNode<Integer> head, ListNode<Integer> after) {
        ListNode<Integer> curr = head, prev = null;
        while (curr != after) {
            ListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

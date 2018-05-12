package com.github.dkoval.algopuzzles.codefights;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://codefights.com/interview-practice/task/6rE3maCQwrZS3Mm2H">mergeTwoLinkedLists</a>
 * Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words,
 * return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.
 */
public class MergeTwoLinkedLists {

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

    static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<>(-1);
        ListNode<Integer> curr1 = l1, curr2 = l2, l3 = dummyHead;
        while (curr1 != null && curr2 != null) {
            if (curr1.value <= curr2.value) {
                l3.next = new ListNode<>(curr1.value);
                curr1 = curr1.next;
            } else {
                l3.next = new ListNode<>(curr2.value);
                curr2 = curr2.next;
            }
            l3 = l3.next;
        }
        while (curr1 != null) {
            l3.next = new ListNode<>(curr1.value);
            l3 = l3.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            l3.next = new ListNode<>(curr2.value);
            l3 = l3.next;
            curr2 = curr2.next;
        }
        return dummyHead.next;
    }
}

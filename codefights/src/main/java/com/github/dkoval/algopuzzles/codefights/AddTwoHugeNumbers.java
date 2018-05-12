package com.github.dkoval.algopuzzles.codefights;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://codefights.com/interview-practice/task/RvDFbsNC3Xn7pnQfH">addTwoHugeNumbers</a>
 * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999
 * that represents a number with exactly 4 digits. The represented number might have leading zeros.
 * Your task is to add up these huge integers and return the result in the same format.
 */
public class AddTwoHugeNumbers {

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

    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> revA = reverseList(a);
        ListNode<Integer> revB = reverseList(b);
        ListNode<Integer> revC = add(revA, revB);

        // reconstruct initial state of the input lists
        reverseList(revA);
        reverseList(revB);
        return reverseList(revC);
    }

    private static ListNode<Integer> reverseList(ListNode<Integer> l) {
        ListNode<Integer> curr = l, prev = null;
        while (curr != null) {
            ListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode<Integer> add(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<>(-1);
        int carry = 0;
        ListNode<Integer> curr1 = l1, curr2 = l2, l3 = dummyHead;
        while (curr1 != null || curr2 != null) {
            int sum = carry;
            if (curr1 != null) {
                sum += curr1.value;
            }
            if (curr2 != null) {
                sum += curr2.value;
            }
            if (sum >= 10_000) {
                sum -= 10_000;
                carry = 1;
            } else {
                carry = 0;
            }

            l3.next = new ListNode<>(sum);
            l3 = l3.next;

            if (curr1 != null) {
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }
        }
        if (carry != 0) {
            l3.next = new ListNode<>(carry);
        }
        return dummyHead.next;
    }
}

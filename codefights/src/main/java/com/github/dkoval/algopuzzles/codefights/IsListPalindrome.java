package com.github.dkoval.algopuzzles.codefights;

/**
 * <a href="https://codefights.com/interview-practice/task/HmNvEkfFShPhREMn4">isListPalindrome</a>
 * Given a singly linked list of integers, determine whether or not it's a palindrome in O(n) time
 * using O(1) additional space.
 */
public class IsListPalindrome {

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

        @Override
        public String toString() {
            return '{' +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    static boolean isListPalindrome(ListNode<Integer> l) {
        if (l == null || l.next == null) {
            return true;
        }

        // split list into 2 halves - l and r
        ListNode<Integer> r, mid = null;
        ListNode<Integer> slow = l, fast = l, prevToSlow = null;
        while (fast != null && fast.next != null) {
            prevToSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            // there is odd number of elements in the list
            r = slow.next;
            mid = slow;
        } else {
            // there is even number of elements in the list
            r = slow;
        }
        // prevToSlow points to the last node of the 1st half of the list
        prevToSlow.next = null;

        // reverse the 2nd half and compare with the 1st half
        r = reverseList(r);
        boolean identical = compareLists(l, r);

        // reconstruct the original list
        r = reverseList(r);
        if (mid != null) {
            prevToSlow.next = mid;
            mid.next = r;
        } else {
            prevToSlow.next = r;
        }

        // make verdict
        return identical;
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

    private static boolean compareLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> curr1 = l1, curr2 = l2;
        while (curr1 != null && curr2 != null) {
            if (curr1.value != null && curr1.value.equals(curr2.value)) {
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else {
                return false;
            }
        }
        return curr1 == null && curr2 == null;
    }
}

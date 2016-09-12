package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, write a method isListPalindrome to determine if the list is a palindrome.
 * A palindrome is a sequence that reads the same backward as forward.
 */
public class IsListPalindrome {

    public static Boolean isListPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // find the middle of the list
        ListNode mid = findMiddle(head);
        // reverse the second half of the list
        mid.next = reverse(mid.next);
        // compare two halves
        return identicalHalves(head, mid.next);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tail = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tail;
        }
        return prev;
    }

    private static boolean identicalHalves(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr2 != null) {
            if (curr2.data != curr1.data) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
}

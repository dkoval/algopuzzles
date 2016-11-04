package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, remove its Nth from the end node.
 */
public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEndInTwoPasses(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        // find the length of the List
        int length = computeLength(head);
        // n appears to be greater than the length of the list
        if (n > length) {
            return head;
        }
        // remove the very first element
        int fromStart = length - n + 1;
        if (fromStart == 1) {
            return head.next;
        }
        ListNode curr = head;
        for (int i = 1; i < fromStart; i++) {
            curr = curr.next;
        }
        // remove Nth from the end
        curr.next = curr.next.next;
        return head;
    }

    private static int computeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static ListNode removeNthFromEndInOnePass(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode fast = head, slow = head;
        // the `fast` pointer is n steps ahead of the `slow` pointer
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // n appears to be greater than the length of the list
                return head;
            }
            fast = fast.next;
        }
        // remove the very first element
        if (fast == null) {
            return head.next;
        }
        // by the time the `fast` pointer reaches the last element of the list,
        // the `slow` pointer points at the previous element of the target element
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

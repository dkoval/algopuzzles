package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, remove its Nth from the end node.
 */
public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // find length of the List
        int length = computeLength(head);
        // find the position
        if (n < 1 || n > length) {
            return head;
        }
        if (n == length) {
            return head.next;
        }
        // remove Nth from the end
        ListNode curr = head;
        for (int i = 1; i < length - n; i++) {
            curr = curr.next;
        }
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
}

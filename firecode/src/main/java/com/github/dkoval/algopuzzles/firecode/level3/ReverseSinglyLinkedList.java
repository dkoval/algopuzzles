package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given the head pointer of a singly linked list, implement a method to reverse the list and return the new head.
 */
public class ReverseSinglyLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tail = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tail;
        }
        return prev;
    }
}

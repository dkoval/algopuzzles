package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a circular-linked list, write a function to delete its tail node and return the modified list's head.
 */
public class DeleteTailOfCircularLinkedList {

    public static ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        ListNode curr = head;
        while (curr.next.next != head) {
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }
}

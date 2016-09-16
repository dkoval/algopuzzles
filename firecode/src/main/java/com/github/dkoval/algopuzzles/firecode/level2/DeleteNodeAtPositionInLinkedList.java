package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, implement a method to delete the node at a given position
 * (starting from 1 as the head position) and return the head of the list.
 * Do nothing if the input position is out of range.
 */
public class DeleteNodeAtPositionInLinkedList {

    public static ListNode deleteAtMiddle(ListNode head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 1) {
            return head.next;
        }
        head.next = deleteAtMiddle(head.next, position - 1);
        return head;
    }

    public static ListNode deleteAtMiddleIterative(ListNode head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 1) {
            return head.next;
        }
        ListNode curr = head, prev = null;
        int i = 1;
        while (curr != null) {
            if (i == position) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        return head;
    }
}

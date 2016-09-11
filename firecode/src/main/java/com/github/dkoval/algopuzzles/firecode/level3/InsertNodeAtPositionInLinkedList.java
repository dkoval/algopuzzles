package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, implement a method to insert a node at a specific position and return the head of the list.
 * <p>
 * If the given position is greater than the list size, simply insert the node at the end.
 */
public class InsertNodeAtPositionInLinkedList {

    public static ListNode insertAtPosition(ListNode head, int data, int pos) {
        if (head == null) {
            return new ListNode(data);
        }
        ListNode curr = head, prev = null;
        int i = 1;
        while (curr != null && i != pos) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode n = new ListNode(data);
        if (prev == null) {
            // insert at first position
            n.next = head;
            head = n;
        } else {
            // insert at the middle or last position
            prev.next = n;
            n.next = curr;
        }
        return head;
    }
}

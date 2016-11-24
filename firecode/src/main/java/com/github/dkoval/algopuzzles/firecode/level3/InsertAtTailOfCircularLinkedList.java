package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a circular linked list, write a method to insert a node at its tail. Return the list's head.
 */
public class InsertAtTailOfCircularLinkedList {

    public static ListNode insertAtTail(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
        return head;
    }
}

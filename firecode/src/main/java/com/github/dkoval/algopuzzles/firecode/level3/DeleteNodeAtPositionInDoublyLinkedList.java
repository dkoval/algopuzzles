package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.DoublyLinkedNode;

/**
 * Given a doubly-linked list, write a method to delete the node at a given position (starting from 1 as the head position)
 * and return the modified list's head. Do nothing if the input position is out of range.
 */
public class DeleteNodeAtPositionInDoublyLinkedList {

    public static DoublyLinkedNode deleteAtPos(DoublyLinkedNode head, int pos) {
        if (head == null) {
            return null;
        }
        DoublyLinkedNode curr = findAtPos(head, pos);
        if (curr == null) {
            // not found
            return head;
        }
        return deleteNode(head, curr);
    }

    private static DoublyLinkedNode findAtPos(DoublyLinkedNode head, int pos) {
        DoublyLinkedNode curr = head;
        int i = 1;
        while (curr != null) {
            if (i == pos) {
                break;
            }
            curr = curr.next;
            i++;
        }
        return (i == pos) ? curr : null;
    }

    private static DoublyLinkedNode deleteNode(DoublyLinkedNode head, DoublyLinkedNode curr) {
        if (curr == head) {
            // delete the head node
            head = curr.next;
            if (head != null) {
                // make sure the list didn't get empty
                head.prev = null;
            }
        } else if (curr.next == null) {
            // delete the tail node
            curr.prev.next = null;
        } else {
            // delete a middle node
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        // reclaim memory
        curr.next = null;
        curr.prev = null;
        return head;
    }
}

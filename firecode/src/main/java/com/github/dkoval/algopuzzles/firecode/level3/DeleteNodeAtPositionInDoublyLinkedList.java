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
        DoublyLinkedNode prev = head.prev, curr = head;
        boolean found = false;
        int i = 1;
        while (curr != null) {
            if (i++ == pos) {
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (found) {
            if (curr == head) {
                // delete the head element
                head = curr.next;
                if (head != null) {
                    // make sure the list didn't get empty
                    head.prev = null;
                }
            } else if (curr.next == null) {
                // delete the tail element
                prev.next = null;
            } else {
                // delete the middle element
                prev.next = curr.next;
                curr.next.prev = prev;
            }
            // reclaim memory
            curr.next = null;
            curr.prev = null;
        }
        return head;
    }
}

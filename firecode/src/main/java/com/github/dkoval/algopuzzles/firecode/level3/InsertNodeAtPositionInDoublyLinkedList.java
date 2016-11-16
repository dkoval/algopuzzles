package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.DoublyLinkedNode;

/**
 * In doubly linked list, implement a method to insert a node at specified position and return the list's head.
 * Do nothing if insertion position is outside the bounds of the list.
 */
public class InsertNodeAtPositionInDoublyLinkedList {

    public static DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        if (head == null && pos == 1) {
            return new DoublyLinkedNode(data);
        }
        // find position
        DoublyLinkedNode prev = head, curr = head;
        int i = 1;
        while (curr != null) {
            if (i == pos) {
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        // insert new node
        if (i < pos) {
            // nothing to do if position is not reachable
            return head;
        } else if (i == 1) {
            // insert new node at heading position
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            newNode.next = curr;
            curr.prev = newNode;
            head = newNode;
        } else if (curr != null) {
            // insert new node at middle position
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            newNode.next = curr;
            newNode.prev = prev;
            prev.next = newNode;
            curr.prev = newNode;
        } else {
            // insert new node at ending position
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            prev.next = newNode;
            newNode.prev = prev;
        }
        return head;
    }
}

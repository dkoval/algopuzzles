package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.DoublyLinkedNode;

/**
 * Given a doubly linked list, implement a method to insert a node at its head. Return the head of the list.
 */
public class InsertNodeAtHeadInDoublyLinkedList {

    public static DoublyLinkedNode insertAtHead(DoublyLinkedNode head, int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        return newNode;
    }
}

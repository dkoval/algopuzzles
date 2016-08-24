package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a circular linked list, implement a method to delete its head node. Return the list's new head node.
 * <pre>
 * *x = indicates head node
 * 1->2->3->4->*1 ==> 2->3->4->*2
 * </pre>
 */
public class DeleteHeadNodeOfCircularLinkedList {

    public static ListNode deleteAtHead(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        head.next = null;
        return curr.next;
    }
}

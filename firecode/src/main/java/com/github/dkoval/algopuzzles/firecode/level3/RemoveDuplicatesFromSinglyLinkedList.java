package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a singly-linked list, remove duplicates in the list and return head of the list.
 * Target a worst case space complexity of O(n).
 */
public class RemoveDuplicatesFromSinglyLinkedList {

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> alreadySeen = new HashSet<>();
        alreadySeen.add(head.data);

        ListNode prev = head, curr = head.next;
        while (curr != null) {
            if (!alreadySeen.add(curr.data)) {
                // remove a duplicate if seen already
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}

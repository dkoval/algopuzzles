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
        if (head == null) {
            return null;
        }
        Set<Integer> alreadySeen = new HashSet<>();
        ListNode prev = head, curr = head;
        while (curr != null) {
            if (alreadySeen.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                alreadySeen.add(curr.data);
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}

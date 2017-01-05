package com.github.dkoval.algopuzzles.firecode.level4;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, reverse the list in pairs.
 */
public class ReverseSinglyLinkedListInPairs {

    public static ListNode reverseInPairs(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            // swap the data between the two adjacent nodes
            int tmp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = tmp;
            // increment the current pointer by two nodes to fetch next pair
            curr = curr.next.next;
        }
        return head;
    }
}

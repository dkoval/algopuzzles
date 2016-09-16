package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, implement the method that returns Nth node from the end of the list without using extra memory
 * (constant space complexity).
 */
public class FindNthNodeFromEndWithoutExtraSpace {

    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        // find the length of the list
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        // find the position
        int NthIndexFromEnd = length - n + 1;
        int i = 1;
        curr = head;
        ListNode found = null;
        while (curr != null) {
            if (i == NthIndexFromEnd) {
                found = curr;
                break;
            }
            curr = curr.next;
            i++;
        }
        return found;
    }
}

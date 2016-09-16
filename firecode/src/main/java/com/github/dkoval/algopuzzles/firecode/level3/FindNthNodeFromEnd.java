package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a singly-linked list, implement the method that returns Nth node from the end of the list.
 * You are allowed to use extra memory for this implementation.
 */
public class FindNthNodeFromEnd {

    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        Map<Integer, ListNode> alreadySeenNodes = new HashMap<>();
        ListNode curr = head;
        int i = 1;
        while (curr != null) {
            alreadySeenNodes.put(i, curr);
            curr = curr.next;
            i++;
        }
        int NthIndexFromEnd = alreadySeenNodes.size() - n + 1;
        return alreadySeenNodes.get(NthIndexFromEnd);
    }
}

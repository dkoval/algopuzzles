package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

/**
 * Given a singly-linked list, check whether its length is even or odd in a single pass.
 * An Empty list has 0 nodes which makes the number of nodes in it even.
 */
public class IsListEven {

    public static Boolean isListEven(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next.next;
        }
        return curr == null;
    }
}

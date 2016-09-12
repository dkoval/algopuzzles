package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a singly-linked list, implement a method to check if the list has cycles.
 * The space complexity can be O(n). If there is a cycle, return true otherwise return false.
 * Empty lists should be considered non-cyclic.
 */
public class DetectCycleInList {

    public static Boolean isCyclic(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

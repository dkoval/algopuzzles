package com.github.dkoval.algopuzzles.firecode.lib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this(data, null);
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public static List<Integer> toList(ListNode head) {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> nodes = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr.data);
            curr = curr.next;
        }
        return nodes;
    }
}

package com.github.dkoval.algopuzzles.firecode.lib;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedNode {
    public int data;
    public DoublyLinkedNode next;
    public DoublyLinkedNode prev;

    public DoublyLinkedNode(int data) {
        this.data = data;
    }

    public static DoublyLinkedNode of(int... data) {
        if (data == null || data.length == 0) {
            return null;
        }
        DoublyLinkedNode head = new DoublyLinkedNode(data[0]), prev = head;
        for (int i = 1; i < data.length; i++) {
            DoublyLinkedNode curr = new DoublyLinkedNode(data[i]);
            prev.next = curr;
            curr.prev = prev;
            prev = curr;
        }
        return head;
    }

    public static List<Integer> toList(DoublyLinkedNode head) {
        if (head == null) {
            return null;
        }
        DoublyLinkedNode curr = head;
        List<Integer> list = new LinkedList<>();
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        return list;
    }
}

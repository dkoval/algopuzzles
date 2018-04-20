package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem">Linked Lists: Detect a Cycle</a>
 * Max Score: 25 Difficulty: Easy
 */
public class DetectCycleInSinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

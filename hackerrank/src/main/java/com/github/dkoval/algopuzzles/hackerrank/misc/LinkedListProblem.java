package com.github.dkoval.algopuzzles.hackerrank.misc;

import java.util.Objects;

/**
 * <a href="https://www.hackerrank.com/challenges/30-linked-list-deletion">30 Days of Code > Day 24 > More Linked Lists</a>
 */
public class LinkedListProblem {

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this(data, null);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node that = (Node) obj;
            return (data == that.data) && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        public static Node create(int... elements) {
            Node head = null;
            for (int element : elements) {
                head = insert(head, element);
            }
            return head;
        }

        public static Node insert(Node head, int data) {
            Node p = new Node(data);
            if (head == null) {
                head = p;
            } else if (head.next == null) {
                head.next = p;
            } else {
                Node start = head;
                while (start.next != null) {
                    start = start.next;
                }
                start.next = p;
            }
            return head;
        }

        public static void display(Node head) {
            Node start = head;
            while (start != null) {
                System.out.print(start.data + " ");
                start = start.next;
            }
        }
    }

    static Node removeDuplicates(Node head) {
        Node current = head;
        while (current != null) {
            Node possibleDuplicate = current;
            while (possibleDuplicate.next != null) {
                if (current.data == possibleDuplicate.next.data) {
                    possibleDuplicate.next = possibleDuplicate.next.next;
                } else {
                    possibleDuplicate = possibleDuplicate.next;
                }
            }
            current = current.next;
        }
        return head;
    }
}

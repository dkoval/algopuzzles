package com.github.dkoval.algopuzzles.epi.ch7.lists;

/**
 * <a href="http://judge.elementsofprogramminginterviews.com:8080/post/list-cycle">Problem:</a>
 * <p>
 * Write a program that takes a reference to the head of a singly linked list and returns null
 * if there does not exist a cycle, and the reference to the start of the cycle, if a cycle is present.
 * (You do not know the length of the list in advance.)
 * </p>
 */
public class CheckForCyclicity {

    public static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode<Integer> solution(ListNode<Integer> head) {
        ListNode<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // there is a cycle
                // find the start of the cycle
                slow = head;
                while (slow != fast) {
                    // both pointers advance at the same time
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // slow is the start of cycle
            }
        }
        return null;
    }
}

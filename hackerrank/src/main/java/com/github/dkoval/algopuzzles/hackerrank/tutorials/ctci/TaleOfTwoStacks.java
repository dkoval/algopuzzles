package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks">Queues: A Tale of Two Stacks</a>
 */
public class TaleOfTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    static class MyStack<T> {

        private static class Node<T> {
            private T data;
            private Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> top;

        public boolean isEmpty() {
            return (top == null);
        }

        public void push(T data) {
            Node<T> newTop = new Node<>(data);
            newTop.next = top;
            top = newTop;
        }

        public T pop() {
            ensureStackIsNotEmpty();
            T data = top.data;
            top = top.next;
            return data;
        }

        public T peek() {
            ensureStackIsNotEmpty();
            return top.data;
        }

        private void ensureStackIsNotEmpty() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
        }
    }

    public static class MyQueue<T> {
        private final MyStack<T> enq = new MyStack<>();
        private final MyStack<T> deq = new MyStack<>();

        public void enqueue(T data) {
            enq.push(data);
        }

        public T dequeue() {
            prepareDeqStack();
            if (!deq.isEmpty()) {
                return deq.pop();
            }
            throw new NoSuchElementException("Queue is empty");
        }

        public T peek() {
            prepareDeqStack();
            if (!deq.isEmpty()) {
                return deq.peek();
            }
            throw new NoSuchElementException("Queue is empty");
        }

        private void prepareDeqStack() {
            if (!deq.isEmpty()) {
                return;
            }
            // transfer the elements from enq to deq
            while (!enq.isEmpty()) {
                T data = enq.pop();
                deq.push(data);
            }
        }
    }
}

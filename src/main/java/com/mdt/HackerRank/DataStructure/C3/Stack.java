package com.mdt.HackerRank.DataStructure.C3;

/**
 * Queue implementation
 */
public class Stack {
    private static class Node {
        private int  data;
        private Node next;

        private Node(int data) {
            data = data;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top       = node;
    }

    public int peek() {
        return top.data;
    }

    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
}

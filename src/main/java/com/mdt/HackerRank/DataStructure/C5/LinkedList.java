package com.mdt.HackerRank.DataStructure.C5;

/**
 *
 */
public class LinkedList<N> {
    Node head;

    public void append(int data) {
        if (head == null) {
            var node = new Node(data);
            return;
        }
        var current = head;
        while (current.next != null)
            current = current.next;
        current.next = new Node(data);
    }

    public void prepend(int data) {
        var newHead = new Node(data);
        newHead.next = head;
        head         = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        var current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next.next = current.next;
                return;
            }
            current = current.next;
        }
    }
}

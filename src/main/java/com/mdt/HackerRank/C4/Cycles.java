package com.mdt.HackerRank.C4;

/**
 * Cycles in a Linked List
 * <p>
 * May 20, 2022
 */
public class Cycles {
    public class Node {
        private int  data;
        private Node next;
    }

    boolean hasCycle(Node head) {
        if (head == null) return false;
        Node fast = head.next;
        Node slow = head;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

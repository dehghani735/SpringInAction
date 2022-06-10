package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * date: 6/10/22
 */
public class P876MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val  = x;
            next = null;
        }
    }
}
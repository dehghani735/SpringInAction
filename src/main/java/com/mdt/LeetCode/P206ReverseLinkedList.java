package com.mdt.LeetCode;

public class P206ReverseLinkedList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            if (head != null) {
                newHead = new ListNode(head.val, null);
                head    = head.next;
            } else
                return head;
            while (head != null) {
                var temp = new ListNode(head.val, newHead);
                newHead = temp;
                head    = head.next;
            }
            return newHead;
        }
    }

    public class ListNode {
        int      val;
        ListNode next;

        ListNode()        {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val  = val;
            this.next = next;
        }
    }
}

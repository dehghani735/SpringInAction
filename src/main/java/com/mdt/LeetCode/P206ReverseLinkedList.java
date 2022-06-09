package com.mdt.LeetCode;

/**
 * Easy
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * date: 6/8/22
 * <p>
 * TODO: solve Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class P206ReverseLinkedList {

    /**
     * my solution: complex and elementary.
     * I think this solution is O(n) space because it clones the list.
     */
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

    /**
     * Nick white's solution => I think this solution is O(1) space, because it does not clone and it's inline reversing.
     */
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                var next = head.next;
                head.next = prev;
                prev      = head;
                head      = next;
            }
            return prev;
        }
    }

    /**
     * TODO: recursively?
     */
    class Solution3 {
        public ListNode reverseList(ListNode head) {
//           TODO
            return null;
        }
    }

    class ListNode {
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

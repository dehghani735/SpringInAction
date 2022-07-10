package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * date: 6/9/22
 * <p>
 * TODO: recursive solution is available in cracking book?
 */
public class P234PalindromeLinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            var slow = head;
            var fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            slow = reversed(slow);
            fast = head;

            while (slow != null) {
                if (slow.val != fast.val)
                    return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        ListNode reversed(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                var next = head.next;
                head.next = prev;
                prev      = head;
                head      = next;
            }
            return prev;
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
}

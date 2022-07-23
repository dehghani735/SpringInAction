package com.mdt.LeetCode.Medium;

import com.mdt.LeetCode.Easy.P21MergeTwoSortedLists;

/**
 * Medium
 * <p>
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * <p>
 * date: 7/22/22
 */
public class P328OddEvenLinkedList {

    /**
     * My solution: I made it complex. Nick's is simpler. TODO do next time
     *
     * @param head
     * @return
     */
    public P21MergeTwoSortedLists.ListNode oddEvenList(P21MergeTwoSortedLists.ListNode head) {
        if (head == null)
            return head;
        var firstOdd = head;
        if (head.next == null)
            return head;
        var firstEven = head.next;
        var tempOdd   = firstOdd;
        var tempEven  = firstEven;
        while (tempOdd != null) {
            if (tempEven.next == null) {
                tempOdd.next = firstEven;
                //tempEven.next = null;
                break;
            }
            tempOdd.next = tempEven.next;
            if (tempOdd.next.next == null) {
                tempOdd.next.next = firstEven;
                tempEven.next     = null;
                break;
            } else {
                tempEven.next = tempOdd.next.next;
                tempOdd       = tempOdd.next;
                tempEven      = tempEven.next;
            }
        }

        return head;
    }
}

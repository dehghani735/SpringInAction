package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * date: 7/01/22
 */
public class P83RemoveDuplicatesFromSortedList {

    /**
     * my solution
     *
     * @param head
     * @return
     */
    public P206ReverseLinkedList.ListNode deleteDuplicates(P206ReverseLinkedList.ListNode head) {
        var current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }
}

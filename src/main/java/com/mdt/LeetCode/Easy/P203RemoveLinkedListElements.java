package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * <p>
 * date: 7/01/22
 */
public class P203RemoveLinkedListElements {

    /**
     * my solution, nice
     *
     * @param head
     * @param val
     * @return
     */
    public P206ReverseLinkedList.ListNode removeElements(P206ReverseLinkedList.ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        var current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }
}

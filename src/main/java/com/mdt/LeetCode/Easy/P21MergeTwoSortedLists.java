package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * date: 6/10/22
 */
public class P21MergeTwoSortedLists {

    /**
     * my solution; whole new nodes creating
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead  = null;
        ListNode lastNode = null;
        ListNode newNode  = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newNode = new ListNode(list1.val, null);
                list1   = list1.next;
            } else {
                newNode = new ListNode(list2.val, null);
                list2   = list2.next;
            }
            if (newHead == null) {
                newHead  = newNode;
                lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode      = newNode;
            }
        }
        while (list1 != null) {
            newNode = new ListNode(list1.val, null);
            if (newHead == null) {
                newHead  = newNode;
                lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode      = newNode;
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            newNode = new ListNode(list2.val, null);
            if (newHead == null) {
                newHead  = newNode;
                lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode      = newNode;
            }
            list2 = list2.next;
        }
        return newHead;
    }


    /**
     * Nick's approach: in-place. creating one new node at the beginning and from there, merging existing nodes.
     * then return next of newNode created at the beginning.
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        return null; // TODO implement later.
    }

    public class ListNode {
        int      val;
        public ListNode next;

        ListNode()        {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val  = val;
            this.next = next;
        }
    }
}

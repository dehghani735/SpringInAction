package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 * <p>
 * date: 1/21/22
 */
public class Q5 {
    private static final Logger log = getLogger(Q5.class);

    public static void main(String[] args) {
        var q5 = new Q5();
        var n1 = new LinkedListNode(9);
        var n2 = new LinkedListNode(9);
        var n3 = new LinkedListNode(9);
        var n4 = new LinkedListNode(9);
        var n5 = new LinkedListNode(9);
        var n6 = new LinkedListNode(1);
//        var n7 = new LinkedListNode(1);
        n1.setPrevious(null);
        n1.setNext(n2);
        n2.setPrevious(n1);
        n2.setNext(n3);
        n3.setPrevious(n2);
        n3.setNext(n4);
        n4.setPrevious(n3);
        n4.setNext(n5);
        n5.setPrevious(n4);
        n5.setNext(null);
        n6.setPrevious(null);
        n6.setNext(null);

        var result = q5.sumListsInReverseOrder(n1, n6);
        while (result != null) {
            System.out.print(result.data + ", ");
            result = result.next;
        }
        System.out.println();
        var result2 = q5.addLists(n1, n6, 0);
        while (result2 != null) {
            System.out.print(result2.data + ", ");
            result2 = result2.next;
        }
    }

    /**
     * my solution
     *
     * @param n1
     * @param n2
     * @return
     */
    public LinkedListNode sumListsInReverseOrder(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode resultRunner = null, result = null;
        var            tenReminder  = 0;
        while (n1 != null && n2 != null) {
            var sum = n1.data + n2.data + tenReminder;
            tenReminder = sum / 10;
            var currentNode = new LinkedListNode(sum % 10);
            currentNode.setNext(null);
            if (result == null) {
                result       = currentNode;
                resultRunner = currentNode;
            } else {
                resultRunner.next = currentNode;
                resultRunner      = currentNode;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        var bigger = n1 != null ? n1 : n2;
        while (bigger != null) {
            var sum = bigger.data + tenReminder;
            tenReminder = sum / 10;
            var currentNode = new LinkedListNode(sum % 10);
            currentNode.setNext(null);
            resultRunner.next = currentNode;
            resultRunner      = currentNode;
            bigger            = bigger.next;
        }
        if (tenReminder != 0) {
            var currentNode = new LinkedListNode(1);
            currentNode.setNext(null);
            resultRunner.next = currentNode;
            resultRunner      = currentNode;
        }
        return result;
    }

    /**
     * recursive solution
     * TODO study again
     *
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;

        var value = carry;
        if (l1 != null)
            value += l1.data;
        if (l2 != null)
            value += l2.data;
        var result = new LinkedListNode(value % 10);
        if (l1 != null || l1 != null) {
            var more = addLists(
                    l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    /**
     * follow up
     * TODO next time
     *
     * @param l1
     * @param l2
     * @return
     */
    public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        // TODO must implement
        return null;
    }
}

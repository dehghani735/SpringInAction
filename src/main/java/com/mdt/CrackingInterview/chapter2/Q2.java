package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * <p>
 * date: 1/15/22
 */
public class Q2 {
    private static final Logger log = getLogger(Q2.class);

    public static void main(String[] args) {
        var q2 = new Q2();
        var n1 = new LinkedListNode(1);
        var n2 = new LinkedListNode(2);
        var n3 = new LinkedListNode(3);
        var n4 = new LinkedListNode(4);
        var n5 = new LinkedListNode(5);
        var n6 = new LinkedListNode(6);
        n1.setPrevious(null);
        n1.setNext(n2);
        n2.setPrevious(n1);
        n2.setNext(n3);
        n3.setPrevious(n2);
        n3.setNext(n4);
        n4.setPrevious(n3);
        n4.setNext(n5);
        n5.setPrevious(n4);
        n5.setNext(n6);
        n6.setPrevious(n5);
        n6.setNext(null);

        var x = n1;
//        var result = q2.findKthToLast(n1, 1);
        var result2 = q2.printKthToLast(x, 2);
//        log.info(String.valueOf(result));
        log.info(String.valueOf(result2));
    }

    public int findKthToLast(LinkedListNode n1, int k) {
        var runner = n1;
        for (int i = 0; i < k; i++) {
            if (runner == null)
                return -1;
            runner = runner.next;
        }
        if (runner == null)
            return -1;

        while (runner.next != null) {
            n1     = n1.next;
            runner = runner.next;
        }

        return n1.data;
    }

    // TODO think deeply
    public int printKthToLast(LinkedListNode head, int k) {
        if (head == null)
            return 0;

        int index = printKthToLast(head.next, k) + 1;
        if (index == k)
            System.out.println(index + " is: " + head.data);

        return index;
    }

    // TODO implement solution using wrapper class to return counter as well
}

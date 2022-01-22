package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * <p>
 * date: 1/18/22
 */
public class Q4 {
    private static final Logger log = getLogger(Q4.class);

    public static void main(String[] args) {
        var q4 = new Q4();
        var n1 = new LinkedListNode(3);
        var n2 = new LinkedListNode(5);
        var n3 = new LinkedListNode(8);
        var n4 = new LinkedListNode(5);
        var n5 = new LinkedListNode(10);
        var n6 = new LinkedListNode(2);
        var n7 = new LinkedListNode(1);
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
        n6.setNext(n7);
        n7.setPrevious(n6);
        n7.setNext(null);

        q4.partition(n1, 11);
        var copy = n1;
        while (copy != null) {
            System.out.print(copy.data + ", ");
            copy = copy.next;
        }
    }

    /**
     * @param head
     * @param partition
     */
    public void partition(LinkedListNode head, int partition) {
        LinkedListNode less    = null, lessHelper = null;
        LinkedListNode greater = null, greaterHelper = null;
        while (head != null) {
            if (head.data < partition) {
                if (less == null)
                    less = head;
                else
                    lessHelper.setNext(head);
                lessHelper = head;
            } else {
                if (greater == null)
                    greater = head;
                else
                    greaterHelper.setNext(head);

                greaterHelper = head;
            }
            head = head.next;
        }
        if (greaterHelper != null)
            greaterHelper.setNext(null);

        if (lessHelper != null) {
            lessHelper.setNext(greater);
            head = lessHelper;
        }
    }
}

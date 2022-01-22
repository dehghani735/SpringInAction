package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
 */
public class Q3 {
    private static final Logger log = getLogger(Q3.class);

    public static void main(String[] args) {
        var q3 = new Q3();
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

//        q3.deleteMiddleNodeBad(n3);
        q3.deleteMiddleNode(n3);

        var copy = n1;
        while (copy != null) {
            System.out.print(copy.data + ", ");
            copy = copy.next;
        }
    }

    /**
     * WTF
     *
     * @param middle
     */
    public void deleteMiddleNodeBad(LinkedListNode middle) {
        if (middle == null)
            return;

        var current = middle;
        var next    = middle.next;
        while (next != null) {
            current.data = next.data;
            current      = current.next;
            next         = current.next;
        }
        current.prev.next = null;
    }

    public void deleteMiddleNode(LinkedListNode middle) {
        if (middle == null || middle.next == null)
            return;

        var next = middle.next;
        middle.data = next.data;
        middle.next = next.next;
    }
}

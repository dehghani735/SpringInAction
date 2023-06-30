package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.8 Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input: A - > B - > C - > D - > E - > C [the same C as earlier]
 * Output: C
 * <p>
 * date: 1/27/22
 */
public class Q8 {
    private static final Logger log = getLogger(Q8.class);

    public static void main(String[] args) {
        var q8 = new Q8();
        var n0 = new LinkedListNode(0);
        var n1 = new LinkedListNode(1);
        var n2 = new LinkedListNode(2);
        var n3 = new LinkedListNode(3);
        var n4 = new LinkedListNode(4);
        var n5 = new LinkedListNode(5);
        var n6 = new LinkedListNode(6);
        var n7 = new LinkedListNode(7);
        var n8 = new LinkedListNode(8);
        var n9 = new LinkedListNode(9);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n4);

        var result = q8.detectLoop(n1);
        log.info(String.valueOf(result));
    }

    /**
     * idea: Much like two cars racing around a track at different steps, they must eventually meet.
     * induce: k is the length before loop. if slow is at the beginning of loop, the runner is k steps in loop.
     *
     * @param n1
     * @return
     */
    private boolean detectLoop(LinkedListNode n1) {
        var slow   = n1;
        var runner = n1;
        while (runner.next != null) {
            slow   = slow.next;
            runner = runner.next.next;
            if (slow == runner)
                return true;
        }
        return false;
    }
}

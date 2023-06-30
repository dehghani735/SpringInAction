package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 * <p>
 * date: 1/27/22
 */
public class Q7 {
    private static final Logger log = getLogger(Q7.class);

    public static void main(String[] args) {
        var q7 = new Q7();
        var n1 = new LinkedListNode(1);
        var n2 = new LinkedListNode(2);
        var n3 = new LinkedListNode(3);
        var n4 = new LinkedListNode(4);
        var n5 = new LinkedListNode(5);
        var n6 = new LinkedListNode(6);
        var n7 = new LinkedListNode(7);
        var n8 = new LinkedListNode(8);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n6);
        n4.setNext(n5);
        n5.setNext(null);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(null);

        var result = q7.checkIntersection1(n1, n4);
        log.info(result.map(linkedListNode -> String.valueOf(linkedListNode.data))
                .orElse("These two singly linked lists don't intersect."));
    }

    /**
     * Using hash table
     *
     * @param n1
     * @param n2
     * @return
     */
    private Optional<LinkedListNode> checkIntersection1(LinkedListNode n1, LinkedListNode n2) {
        var hashSet = new HashSet<LinkedListNode>();
        var l1      = n1;
        var l2      = n2;
        while (l1 != null) {
            hashSet.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            if (hashSet.contains(l2))
                return Optional.of(l2);
            l2 = l2.next;
        }
        return Optional.empty();
    }

    /**
     * idea: they have same end node
     * @param n1
     * @param n2
     * @return
     */
    private Optional<LinkedListNode> checkIntersection2(LinkedListNode n1, LinkedListNode n2) {
//        TODO implement next time
        return Optional.empty();
    }
}

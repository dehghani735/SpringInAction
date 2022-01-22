package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed
 * <p>
 * date: 1/14/22
 */
public class Q1 {
    private static final Logger log = getLogger(Q1.class);

    public static void main(String[] args) {

//         TODO study deeply: java LinkedList Doubly-linked list implementation of the List and Deque interfaces
        LinkedList<Integer> linkedList = new LinkedList<Integer>(List.of(1, 2, 3, 4, 5, 4, 5, 2, 3, 8, 9));

        var q1     = new Q1();
        var result = q1.removeDups1(linkedList);
        result.stream().forEach(
                it -> System.out.print(it)
        );
        System.out.println();

        var n1 = new LinkedListNode(1);
        var n2 = new LinkedListNode(1);
        var n3 = new LinkedListNode(2);
        var n4 = new LinkedListNode(2);
        var n5 = new LinkedListNode(3);
        var n6 = new LinkedListNode(4);
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

        var result2 = q1.removeDups2(n1);
        while (result2 != null) {
            System.out.print(result2.data + ", ");
            result2 = result2.next;
        }
    }

    // TODO book has its own implementation. consider that next time
    public LinkedList<Integer> removeDups1(LinkedList<Integer> linkedList) {
        // TODO study deeply: This class implements the Set interface, backed by a hash table (actually a HashMap instance).
        var set = new HashSet<Integer>();
        for (int i = 0; i < linkedList.size(); i++) {
            if (set.contains(linkedList.get(i))) {
                linkedList.remove(i--);
            } else {
                set.add(linkedList.get(i));
            }
        }

        return linkedList;
    }

    public LinkedListNode removeDups2(LinkedListNode head) {
        LinkedListNode secondPointer = null;
        var            result        = head;
        while (head != null) {
            secondPointer = head.next;
            while (secondPointer != null) {
                if (head.data == secondPointer.data) {
                    secondPointer.prev.next = secondPointer.next;
                    secondPointer           = secondPointer.next;
                } else {
                    secondPointer = secondPointer.next;
                }
            }
            head = head.next;
        }

        return result;
    }
}

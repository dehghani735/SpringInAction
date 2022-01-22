package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 * <p>
 * date: 1/21/22
 */
public class Q6 {
    private static final Logger log = getLogger(Q6.class);

    public static void main(String[] args) {
        var q6 = new Q6();
        var n1 = new LinkedListNode(0);
        var n2 = new LinkedListNode(5);
        var n3 = new LinkedListNode(4);
        var n4 = new LinkedListNode(4);
        var n5 = new LinkedListNode(5);
        var n6 = new LinkedListNode(0);
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

        var result = q6.checkPalindrome1(n1);
        log.info(String.valueOf(result));
    }

    /**
     * first idea: forward and backward are the same
     *
     * @param l1
     * @return
     */
    public boolean checkPalindrome1(LinkedListNode l1) {
        var reverse = reverseLinkedList(l1);
        return isEqual(l1, reverse);
    }

    /**
     * simple and nice
     *
     * @param l1
     * @return
     */
    private LinkedListNode reverseLinkedList(LinkedListNode l1) {
        LinkedListNode head = null;
        while (l1 != null) {
            var n = new LinkedListNode(l1.data); // clone
            n.setNext(head);
            head = n;
            l1   = l1.next;
        }
        return head;
    }

    private boolean isEqual(LinkedListNode l1, LinkedListNode reverse) {
        while (l1 != null && reverse != null) {
            if (l1.data != reverse.data)
                return false;
            l1      = l1.next;
            reverse = reverse.next;
        }
        if (l1 != null || reverse != null)
            return false;
        return true;
    }

    /**
     * idea: put half of the linked list into stack and compare the next half with the stack.
     *
     * @param l1
     * @return
     */
    public boolean checkPalindrome2(LinkedListNode l1) {

    }
}

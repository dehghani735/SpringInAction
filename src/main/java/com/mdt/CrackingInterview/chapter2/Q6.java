package com.mdt.CrackingInterview.chapter2;

import org.slf4j.Logger;

import java.util.Stack;

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
        var nm = new LinkedListNode(10);
        var n4 = new LinkedListNode(4);
        var n5 = new LinkedListNode(5);
        var n6 = new LinkedListNode(0);
        n1.setPrevious(null);
        n1.setNext(n2);
        n2.setPrevious(n1);
        n2.setNext(n3);
        n3.setPrevious(n2);
        n3.setNext(nm);
        nm.setPrevious(n3);
        nm.setNext(n4);
        n4.setPrevious(nm);
        n4.setNext(n5);
        n5.setPrevious(n4);
        n5.setNext(n6);
        n6.setPrevious(n5);
        n6.setNext(null);

        var input1  = n1;
        var result1 = q6.checkPalindrome1(input1);
        log.info(String.valueOf(result1));

        var input2  = n1;
        var result2 = q6.checkPalindrome2(input2);
        log.info(String.valueOf(result2));
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
        var stack  = new Stack<>();
        var runner = l1;
        while (runner != null && runner.next != null) {
            stack.push(l1.data);
            l1     = l1.next;
            runner = runner.next.next;
        }
        if (runner != null)
            l1 = l1.next;
        while (l1 != null) {
            if (l1.data != (int) stack.pop())
                return false;
            l1 = l1.next;
        }
        return true;
    }

    /**
     * idea: Recursive
     *
     * @param l1
     * @return
     */
    public boolean checkPalindrome3(LinkedListNode l1) {
//        TODO implement later
        return false;
    }
}

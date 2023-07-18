package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * <p>
 * <p>
 * date: 7/01/22
 */
public class P160IntersectionOfTwoLinkedLists {

    /**
     * my solution, but complex
     *
     * @param headA
     * @param headB
     * @return
     */
    public P206ReverseLinkedList.ListNode getIntersectionNode(P206ReverseLinkedList.ListNode headA, P206ReverseLinkedList.ListNode headB) {
        var currentA = headA;
        var currentB = headB;
        int counterA = 0, counterB = 0;
        while (currentA != null && currentA.next != null) {
            currentA = currentA.next;
            counterA++;
        }
        while (currentB != null && currentB.next != null) {
            currentB = currentB.next;
            counterB++;
        }
        if (currentA != currentB)
            return null;

        currentA = headA;
        currentB = headB;
        var diff = Math.abs(counterA - counterB);
        if (counterA > counterB) {
            while (diff != 0) {
                currentA = currentA.next;
                diff--;
            }
        }
        if (counterB > counterA) {
            while (diff != 0) {
                currentB = currentB.next;
                diff--;
            }
        }

        while (currentA != null) {
            if (currentA == currentB)
                return currentA;
            else {
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        return null;
    }

    /**
     * Nick's solution, very nice idea.
     * <p>
     * Idea: by swapping pointer, they will be at the same point in second round;
     *
     * @param headA
     * @param headB
     * @return
     */
    public P206ReverseLinkedList.ListNode getIntersectionNode2(P206ReverseLinkedList.ListNode headA, P206ReverseLinkedList.ListNode headB) {
        var aPointer = headA;
        var bPointer = headB;
        while (aPointer != bPointer) {
            if (aPointer == null)
                aPointer = headB;
            else
                aPointer = aPointer.next;

            if (bPointer == null)
                bPointer = headA;
            else
                bPointer = bPointer.next;
        }

        return aPointer;
    }
}

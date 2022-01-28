package com.mdt.CrackingInterview.chapter3;

/**
 * Fixed Multi-stack using a single array.
 * <p>
 * date: 1/28/22
 */
public class FixedMultiStack {
    private int   stackCapacity;
    private int   numberOfStacks = 3;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        values             = new int[numberOfStacks * stackCapacity];
        sizes              = new int[3];
    }

    public void push(int stackNum, int data) throws Exception {
        if (isFull(stackNum))
            throw new Exception("Stack is Full."); // TODO make specific exceptions
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = data;
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum))
            throw new Exception("Stack is Empty.");
        var topIndex = indexOfTop(stackNum);
        var value    = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;

        return value;
    }

    public int peek(int stackNum) throws Exception {
        if (isEmpty(stackNum))
            throw new Exception("Stack is Empty.");
        return values[indexOfTop(stackNum)];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        var offset = stackNum * stackCapacity;
        var size   = sizes[stackNum];

        return offset + size - 1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }
}

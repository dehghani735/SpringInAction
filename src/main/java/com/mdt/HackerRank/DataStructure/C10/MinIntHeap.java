package com.mdt.HackerRank.DataStructure.C10;

import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size     = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex)  {return 2 * parentIndex + 1;}

    private int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2;}

    private int getParentIndex(int childIndex)      {return (childIndex - 1) / 2;}

    private boolean hasLeftChild(int index)         {return getLeftChildIndex(index) < size;}

    private boolean hasRightChild(int index)        {return getRightChildIndex(index) < size;}

    private boolean hasParent(int index)            {return getParentIndex(index) >= 0;}

    private int leftChild(int index)                {return items[getLeftChildIndex(index)];}

    private int rightChild(int index)               {return items[getRightChildIndex(index)];}

    private int parent(int index)                   {return items[getParentIndex(index)];}

    private void swap(int indexOne, int indexTwo) {
        var temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    /**
     * if the array is full, double it
     */
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2); // nice
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        var root = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return root;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        var index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        var index = 0;
        while (hasLeftChild(index)) {
            var smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex])
                break;
            else
                swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }
}

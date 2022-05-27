package com.mdt.HackerRank.DataStructure.C2;

import java.util.Stack;

/**
 * Queue With Two Stacks
 */
public class Solution {
    public static class MyQueue<T> {
        private Stack<T> stackNewestOnTop = new Stack<T>();
        private Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        public T peek() {
            // move elements from stackNewest to stackOldest
            shiftStacks();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            // move elements from stackNewest to stackOldest
            shiftStacks();
            return stackOldestOnTop.pop();
        }

        private void shiftStacks() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty())
                    stackNewestOnTop.push(stackOldestOnTop.pop());
            }
        }
    }

    public static void main(String[] args) {

    }
}

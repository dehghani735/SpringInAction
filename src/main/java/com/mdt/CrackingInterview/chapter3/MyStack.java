package com.mdt.CrackingInterview.chapter3;

/**
 * A linked-list implementation of stack.
 * stack has four operations:
 * 1. pop()
 * 2. push(T t)
 * 3. peek()
 * 4. isEmpty()
 * date: 1/27/22
 *
 * @author mdt
 */
public class MyStack<T> {
    private StackNode<T> top;

    public T pop() throws Exception {
        if (top == null)
            throw new Exception("Stack is Empty"); // TODO make specific exceptions

        var data = top.data;
        top = top.next;

        return data;
    }

    public void push(T data) {
        var node = new StackNode(data);
        node.next = top;
        top       = node;
    }

    public T peek() throws Exception {
        if (top == null)
            throw new Exception("Stack is Empty");

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // TODO why static class?
    private static class StackNode<T> {
        private T            data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }
}

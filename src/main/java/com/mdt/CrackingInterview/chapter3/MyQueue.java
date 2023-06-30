package com.mdt.CrackingInterview.chapter3;

/**
 * A linked-list implementation of Queue.
 * stack has four operations:
 * 1. add(T t)
 * 2. remove()
 * 3. peek()
 * 4. isEmpty()
 * <p>
 * Applications:
 * BFS
 * Cache
 * <p>
 * date: 1/27/22
 *
 * @author mdt
 */
public class MyQueue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data) {
        var node = new QueueNode<T>(data);
        if (last != null)
            last.next = node;
        last = node;
        if (first == null)
            first = node;
    }

    public T remove() throws Exception {
        if (first == null)
            throw new Exception("Stack is Empty");
        var value = first.data;
        first = first.next;
        if (first == null)
            last = null;

        return value;
    }

    public T peek() throws Exception {
        if (first == null)
            throw new Exception("Stack is Empty");

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // TODO why static class?
    private static class QueueNode<T> {
        private T            data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }
}

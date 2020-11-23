package com.mdt.ocp.chapter3.JavaCollectionsFramework.QueueInterface;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4));
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        // stack functionality
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek()); // 4
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.peek()); //
    }
}

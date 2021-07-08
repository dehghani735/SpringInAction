package com.mdt.ocp.chapter7.ConcurrentCollections;

import java.util.*;
import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());

        System.out.println("===");
        //
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }
        System.out.println("===");
        //
        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS); // 5, 91, 47, 3
            System.out.println(blockingDeque.poll()); // 5
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS)); // 91
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS)); // 47
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS)); // 3
        } catch (InterruptedException e) {
            // Handle interruption
        }
        System.out.println("===");
        // CopyOnWrite
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
//        List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 52)); // throw ConcurrentModificationException
        for (Integer item : list) {
            System.out.print(item + " ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: " + list.size());
        //
    }
}

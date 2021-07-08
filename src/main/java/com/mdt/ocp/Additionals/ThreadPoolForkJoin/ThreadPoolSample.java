package com.mdt.ocp.Additionals.ThreadPoolForkJoin;
//import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

//import static org.junit.jupiter.api.Assertions.assertEquals;


public class ThreadPoolSample {

    public static void main(String[] args) {

        // The main configuration parameters that we'll discuss here are: corePoolSize, maximumPoolSize, and keepAliveTime.
        //The pool consists of a fixed number of core threads that are kept inside all the time, and some excessive threads that may be spawned and then terminated when they are not needed anymore.
        // The corePoolSize parameter is the number of core threads that will be instantiated and kept in the pool.
        // When a new task comes in, if all core threads are busy and the internal queue is full, then the pool is allowed to grow up to maximumPoolSize.
        //The keepAliveTime parameter is the interval of time for which the excessive threads (instantiated in excess of the corePoolSize) are allowed to exist in the idle state.
        // By default, the ThreadPoolExecutor only considers non-core threads for removal. In order to apply the same removal policy to core threads, we can use the allowCoreThreadTimeOut(true) method.

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        System.out.println(executor.getPoolSize() + " " + executor.getQueue().size());

        //================

        // Another pre-configured ThreadPoolExecutor can be created with the Executors.newCachedThreadPool() method.
        // This method does not receive a number of threads at all.
        // The corePoolSize is actually set to 0, and the maximumPoolSize is set to Integer.MAX_VALUE for this instance.
        // The keepAliveTime is 60 seconds for this one.

        // These parameter values mean that the cached thread pool may grow without bounds to accommodate any number of submitted tasks.
        // But when the threads are not needed anymore, they will be disposed of after 60 seconds of inactivity.
        // A typical use case is when you have a lot of short-living tasks in your application.

        // The queue size in the example above will always be zero because internally a SynchronousQueue instance is used.
        // In a SynchronousQueue, pairs of insert and remove operations always occur simultaneously, so the queue never actually contains anything.
        ThreadPoolExecutor executor2 =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

//        assertEquals(3, executor2.getPoolSize());
//        assertEquals(0, executor2.getQueue().size());

        // The Executors.newSingleThreadExecutor() API creates another typical form of ThreadPoolExecutor containing a single thread.
        // The single thread executor is ideal for creating an event loop. The corePoolSize and maximumPoolSize parameters are equal to 1, and the keepAliveTime is zero.

        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        executor3.submit(() -> {
            counter.set(1);
        });
        executor3.submit(() -> {
            counter.compareAndSet(1, 2);
        });

        System.out.println(counter.get());


        // ForkJoinPool
        // ForkJoinPool is the central part of the fork/join framework introduced in Java 7.
        // It solves a common problem of spawning multiple tasks in recursive algorithms.
        // Using a simple ThreadPoolExecutor, you will run out of threads quickly, as every task or subtask requires its own thread to run.
        // In a fork/join framework, any task can spawn (fork) a number of subtasks and wait for their completion using the join method.
        // The benefit of the fork/join framework is that it does not create a new thread for each task or subtask, implementing the Work Stealing algorithm instead.

    }
}

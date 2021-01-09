package com.mdt.ocp.chapter7.ThreadsWithExecutorService;

public class IncreasingConcurrencyWithPools {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 16-thread pool in a 2-CPU computer for CPU-intensive tasks vs I/O intensive tasks
    }
}

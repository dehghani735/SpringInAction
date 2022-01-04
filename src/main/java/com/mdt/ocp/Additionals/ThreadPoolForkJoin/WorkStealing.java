package com.mdt.ocp.Additionals.ThreadPoolForkJoin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class WorkStealing {
    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
    }
}

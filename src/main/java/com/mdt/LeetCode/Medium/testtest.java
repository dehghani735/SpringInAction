package com.mdt.LeetCode.Medium;

import org.jooq.tools.StopWatch;

public class testtest {

    public static void main(String[] args) {

        var stopWatch = new StopWatch();
        System.out.println(sum());

        stopWatch.splitDebug("sum completed:");
    }

    // Hideously slow! Can you spot the object creation?
    private static long sum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
             sum += i;
        return sum;
    }
}

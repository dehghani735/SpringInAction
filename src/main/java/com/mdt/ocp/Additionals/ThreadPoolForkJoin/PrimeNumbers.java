package com.mdt.ocp.Additionals.ThreadPoolForkJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeNumbers extends RecursiveAction {

    private int lowerBound;
    private int upperBound;
    private int granularity;
    static final List<Integer> GRANULARITIES
            = Arrays.asList(1, 10, 100, 1000, 10000);
    private AtomicInteger noOfPrimeNumbers;

    PrimeNumbers(int lowerBound, int upperBound, int granularity, AtomicInteger noOfPrimeNumbers) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.granularity = granularity;
        this.noOfPrimeNumbers = noOfPrimeNumbers;
    }

    // other constructors and methods

    private List<PrimeNumbers> subTasks() {
        List<PrimeNumbers> subTasks = new ArrayList<>();

        for (int i = 1; i <= this.upperBound / granularity; i++) {
            int upper = i * granularity;
            int lower = (upper - granularity) + 1;
            subTasks.add(new PrimeNumbers(lower, upper, 1, noOfPrimeNumbers));
        }
        return subTasks;
    }

    @Override
    protected void compute() {
        if (((upperBound + 1) - lowerBound) > granularity) {
            ForkJoinTask.invokeAll(subTasks());
        } else {
            findPrimeNumbers();
        }
    }

    void findPrimeNumbers() {
        for (int num = lowerBound; num <= upperBound; num++) {
            if (isPrime(num)) {
                noOfPrimeNumbers.getAndIncrement();
            }
        }
    }

    private boolean isPrime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return true;
        else
            return false;
    }

    public int noOfPrimeNumbers() {
        return noOfPrimeNumbers.intValue();
    }

    public static void main(String[] args) {
//        PrimeNumbers primes = new PrimeNumbers(10000);
//        ForkJoinPool pool = ForkJoinPool.commonPool();
//        pool.invoke(primes);
//        pool.shutdown();
    }
}

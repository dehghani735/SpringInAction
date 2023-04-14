package com.mdt.FunctionalAndReactive.M10_17_Parallelism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SettingParallelism {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2"); // TODO so don't use all of the cores.
//         some of them are needed for main and other tasks

        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ForkJoinPool pool = new ForkJoinPool(2); // number of threads is not limited by the number of processors

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Rohn", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Bheem", 8000));
            list.add(new Employee("Shiva", 200));
            list.add(new Employee("Krishna", 50000));
        }

        try {
            Long count = pool.submit(() ->
                    list.parallelStream()
                            .filter(e -> e.salary > 1000)
                            .count()
            ).get();

            System.out.println(count);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        // CPU-intensive: number of threads <= number of cores
        // I/O-intensive: number of threads can be greater than the number of cores
    }

    private record Employee(String name, int salary) {
    }
}

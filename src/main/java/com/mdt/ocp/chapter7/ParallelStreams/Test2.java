package com.mdt.ocp.chapter7.ParallelStreams;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }
}

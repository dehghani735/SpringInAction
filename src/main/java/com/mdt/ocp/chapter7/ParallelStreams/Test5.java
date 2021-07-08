package com.mdt.ocp.chapter7.ParallelStreams;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
            .stream()
            .reduce("", (c, s1) -> c + s1,
                (s2, s3) -> s2 + s3));

        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
            .parallelStream()
            .reduce(0, (a, b) -> (a - b))); // NOT AN ASSOCIATIVE ACCUMULATOR

        System.out.println(Arrays.asList("w", "o", "l", "f")
            .parallelStream()
            .reduce("X", String::concat));


    }
}

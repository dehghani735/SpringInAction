package com.mdt.FunctionalAndReactive.M10_Streams.M10_8_Reduce;

import java.util.stream.Stream;

public class ReduceOperation {

    public static void main(String[] args) {
        var x = Stream.of(1, 2, 4, 67, 87, 65, 46)
                .reduce(0, (a, b) -> a + b);
        System.out.println(x);
    }
}

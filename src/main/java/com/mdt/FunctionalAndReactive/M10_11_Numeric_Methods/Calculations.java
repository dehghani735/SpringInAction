package com.mdt.FunctionalAndReactive.M10_11_Numeric_Methods;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculations {

    public static void main(String[] args) {

        // IntStream
        // LongStream
        // DoubleStream

        // sum
        int sum = IntStream.of(1,2,3)
                .sum();
        System.out.println(sum);

        // max() Optional: primitive
        OptionalInt maxOptional = IntStream.of() //
                .max();
        System.out.println(maxOptional.orElse(0));

        // min()

        // average()

        // summaryStatistics
        IntSummaryStatistics intSummaryStatistics = IntStream.of(1, 2, 34)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}

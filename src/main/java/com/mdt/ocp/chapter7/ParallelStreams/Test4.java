package com.mdt.ocp.chapter7.ParallelStreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
//        Stream<String> s3 = Stream.of("monkey", "gorilla", "bonobo");
//        Stream<String> infinite = Stream.generate(() -> "Chill");
//        s3.findAny().ifPresent(System.out::println);
//        infinite.findAny().ifPresent(System.out::println);

        System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get());

        System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get());
        System.out.println("");
        System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6, 7).parallelStream().skip(5).limit(2).findFirst());

        // creating unordered streams
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().unordered();

    }
}

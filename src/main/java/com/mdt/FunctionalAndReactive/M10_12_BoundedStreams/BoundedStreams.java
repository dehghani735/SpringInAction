package com.mdt.FunctionalAndReactive.M10_12_BoundedStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BoundedStreams {

    public static void main(String[] args) {

        // 1. stream() on a collection
        var list = List.of(1, 4, 7, 9);
        var streamIntegers = list.stream();

        // 2. How we can stream a Map
        var map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
        var entries = map.entrySet().stream();
        var values = map.values().stream();
        var keys = map.keySet().stream();

        // 3. stream() of Arrays Class
        Integer[] integerArr = {3, 5, 7, 9};
        var stream = Arrays.stream(integerArr);

        int[] intArr = {3, 5, 7, 9};
        var stream2 = Arrays.stream(intArr);

        // 4. builder() of Stream class
        Stream.Builder<Integer> builder = Stream.builder(); // more convenient way, because we can add elements whenever and wherever we want
        builder.add(1);
        builder.add(4);
        Stream<Integer> stream3 = builder.build();
    }
}

package com.mdt.FunctionalAndReactive.M13_OwnCollectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2, 4, 6, 7, 9, 6, 43, 65, 32, 45, 78, 99, 6, 54, 12);

        Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(ArrayList::new, // Supplier
                (list, e) -> list.add(e), // BiConsumer
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }, // BiFunction
                Collector.Characteristics.IDENTITY_FINISH);

        List<Integer> evens = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(toList);
        evens.forEach(System.out::println);

        // we want to build a collector that adds elements in the list in a sorted order
        // we will use the overloaded version of Collector.of
        Collector<Integer, List<Integer>, List<Integer>> toSortedListCollector = Collector.of(ArrayList::new, // Supplier
                (list, e) -> list.add(e), // BiConsumer
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }, // BiFunction
                (list) -> {
                    Collections.sort(list);
                    return list;
                }, // finisher
                Collector.Characteristics.UNORDERED);
        // here finished is not an identity function.

        List<Integer> sortedList = numbers
                .stream()
                .collect(toSortedListCollector);

        System.out.println("-------");

        sortedList.forEach(System.out::println);
    }
}

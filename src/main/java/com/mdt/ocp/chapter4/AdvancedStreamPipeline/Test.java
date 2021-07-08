package com.mdt.ocp.chapter4.AdvancedStreamPipeline;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");
        Stream<String> stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count());
        System.out.println("===");

        // collecting Results
        // Collecting Using Basic Collectors
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", ")); // Note: its Collectors not Collector
        System.out.println(result); // lions, tigers, bears
        System.out.println("===");

        //
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
        System.out.println(result2); // 5.333333333333333
        System.out.println("===");
        //
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result3 = ohMy3.filter(s -> s.startsWith("t"))
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result3); // [tigers]
        System.out.println("===");
        // collecting into maps
        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy4.collect(
            Collectors.toMap(s -> s, String::length)); // s-> s is equal to Function.identity()
        System.out.println(map); // {lions=5, bears=5, tigers=6}
        System.out.println("===");

        // toMap
        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
//        Map<Integer, String> map2 = ohMy5.collect(Collectors.toMap(String::length, k ->
//                k)); // BAD because two we have 2 keys with 5 and We didn’t tell Java what to do

        // toMap with merge
        Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map3 = ohMy6.collect(Collectors.toMap(
            String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map3); // {5=lions,bears, 6=tigers}
        System.out.println(map3.getClass()); // class. java.util.HashMap
        System.out.println("===");
        // toMap with merge and return type
        Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map4 = ohMy7.collect(Collectors.toMap(
            String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map4); // // {5=lions,bears, 6=tigers}
        System.out.println(map4.getClass()); // class. java.util.TreeMap
        System.out.println("===");
        // Collecting Using Grouping, Partitioning, and Mapping
        Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map5 = ohMy8.collect(
            Collectors.groupingBy(String::length));
        System.out.println(map5); // {5=[lions, bears], 6=[tigers]}
        System.out.println("===");
        // with donwstream collector
        Stream<String> ohMy9 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map6 = ohMy9.collect(
            Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map6); // {5=[lions, bears], 6=[tigers]}
        System.out.println("===");

        //
        Stream<String> ohMy10 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map7 = ohMy10.collect(
            Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map7); // {5=[lions, bears], 6=[tigers]}
        System.out.println("===");
        // partitioning
        Stream<String> ohMy11 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map8 = ohMy11.collect(
            Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map8); // {false=[tigers], true=[lions, bears]}
        System.out.println("===");
        // partiotioning to set
        Stream<String> ohMy12 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map9 = ohMy12.collect(
            Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map9);// {false=[], true=[lions, tigers, bears]}
        System.out.println("===");

        //
        Stream<String> ohMy13 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map10 = ohMy13.collect(Collectors.groupingBy(
            String::length, Collectors.counting()));
        System.out.println(map10); // {5=2, 6=1}
        System.out.println("===");

        //

    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
            .filter(s -> s.length() == 3) // part 2
            .ifPresent(System.out::println); // part 3
    }
}

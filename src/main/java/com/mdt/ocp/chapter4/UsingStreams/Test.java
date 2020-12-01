package com.mdt.ocp.chapter4.UsingStreams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        System.out.println(empty);
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 3, 4); // to create a stream from an array. You’ve undoubtedly
        // noticed that there isn’t an array on line 3. The method signature uses varargs,

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        // infinite streams
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
//        randoms.forEach(System.out::println); // until you kill it

        // count
        Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s1.count());
        // min
        Stream<String> s2 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s2.min((x, y) -> x.length() - y.length());
        min.ifPresent(System.out::println);
        // min
        Optional<?> minEmpty = Stream.empty().min((x, y) -> 0);
        System.out.println(minEmpty.isPresent());

        // findAny
        Stream<String> s3 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "Chill");
        s3.findAny().ifPresent(System.out::println);
        infinite.findAny().ifPresent(System.out::println);

        // anyMatch, allMatch, noneMatch
        List<String> list2 = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list2.stream().anyMatch(pred)); // true
        System.out.println(list2.stream().allMatch(pred)); // false
        System.out.println(list2.stream().noneMatch(pred)); // false
        System.out.println(infinite2.anyMatch(pred)); // true
        System.out.println("===");
        // forEach
        Stream<String> s4 = Stream.of("Monkey", "Gorilla", "Bonobo");
        s4.forEach(System.out::print);
        System.out.println("===");
        // reduce
        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        String word = stream1.reduce("", String::concat);
        System.out.println(word);
        System.out.println("===");
        // reduce
        Stream<Integer> stream2 = Stream.of(2, 4);
        Integer multiply = stream2.reduce(2, (x, y) -> x * y);
        System.out.println("multiplied: " + multiply);
        System.out.println("===");
        // reduce with no identity
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty1 = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        empty1.reduce(op).ifPresent(System.out::print); // no output
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90
        System.out.println("===");
        //
        BinaryOperator<Integer> op2 = (a, b) -> a * b;
        Stream<Integer> stream = Stream.of(3, 5, 6);
        System.out.println(stream.reduce(1, op2, op2)); // 90
        System.out.println("===");
        // collect
        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        StringBuilder word1 = stream3.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word1);
        System.out.println("===");
        // collect with different accumulator and combiner
        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream4.collect(TreeSet::new, TreeSet::add,
                TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]
        System.out.println("===");
        // collect with Collectors
        Stream<String> stream5 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set1 = stream5.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1); // [f, l, o, w]
        System.out.println("===");
        // not sorted
        Stream<String> stream6 = Stream.of("w", "o", "l", "f");
        Set<String> set2 = stream6.collect(Collectors.toSet());
        System.out.println(set2); // [f, w, l, o]
        System.out.println("===");
        // Intermediate Operations
        // filter
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey
        System.out.println("===");
        // distinct
        Stream<String> s5 = Stream.of("duck", "duck", "duck", "goose");
        s5.distinct().forEach(System.out::print); // duckgoose
        System.out.println("===");
        // skip and limit
        Stream<Integer> s6 = Stream.iterate(1, n -> n + 1);
        s6.skip(5).limit(2).forEach(System.out::print); // 67
        System.out.println("===");
        // map
        Stream<String> s7 = Stream.of("monkey", "gorilla", "bonobo");
        s7.map(String::length).forEach(System.out::print); // 676
        System.out.println("===");
        // flatMap()
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        // ** parameter is List<String>
        animals.flatMap(l -> l.stream()).forEach(System.out::println);
        System.out.println("===");
        // sorted()
        Stream<String> s8 = Stream.of("brown-", "bear-");
        s8.sorted().forEach(System.out::print); // bear-brown
        System.out.println("===");
        // sorted with Comparator
        Stream<String> s9 = Stream.of("brown bear-", "grizzly-");
        s9.sorted(Comparator.reverseOrder()) // tricky note here, we have to use method not method reference.
                .forEach(System.out::print); // grizzly-brown bear-
        System.out.println("===");
        // peek()
        Stream<String> stream7 = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream7.filter(s10 -> s10.startsWith("g"))
                .peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1
        System.out.println("===");
        // danger with peek
        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> stream8 = Stream.of(numbers, letters);
        stream8.map(List::size).forEach(System.out::print); // 11

        StringBuilder builder = new StringBuilder();
        Stream<List<?>> good = Stream.of(numbers, letters);
        good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::print); // 11
        System.out.println(builder); // [1][a]
        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print); // 00
        System.out.println("===");
        //
        List<String> list3 = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list3.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);

    }
}

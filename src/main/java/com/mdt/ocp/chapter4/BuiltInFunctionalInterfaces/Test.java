package com.mdt.ocp.chapter4.BuiltInFunctionalInterfaces;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        // static method reference
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1);
        System.out.println(d2);

        // constructor reference
        Supplier<StringBuilder> s3 = StringBuilder::new;
        Supplier<StringBuilder> s4 = () -> new StringBuilder();
        System.out.println(s3.get());
        System.out.println(s4.get());

        //
        Supplier<ArrayList<String>> s5 = ArrayList<String>::new;
        ArrayList<String> a1 = s5.get();
        System.out.println(a1);
        System.out.println(s5);

        // Consumer
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("MDT");
        c2.accept("Yazd");

        // BiConsumer
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = (k, v) -> map.put(k,v);
        BiConsumer<String, Integer> b2 = map::put;
        b1.accept("chicken", 7);
        b1.accept("chick", 1);
        System.out.println(map);

        //
        Map<String, String> capital = new HashMap<>();
        BiConsumer<String, String> b3 = (k, v) -> capital.put(k, v);
        BiConsumer<String, String> b4 = capital::put;

        b3.accept("Iran", "Tehran");
        b4.accept("Italy", "Roma");

        System.out.println(capital);

        // Predicate
        Predicate<String> p1 = s -> s.isEmpty();
        Predicate<String> p2 = String::isEmpty;

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));
        //
        BiPredicate<String, String> bp1 = (string, prefix) -> string.startsWith(prefix);
        BiPredicate<String, String> bp2 = String::startsWith;

        System.out.println(bp1.test("chicken", "chick"));
        System.out.println(bp2.test("chicken", "chick"));
        // Default Methods on Functional Interfaces
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

        Predicate<String> brownEggs2 = egg.and(brown);
        Predicate<String> otherEggs2 = egg.and(brown.negate());

        // Function
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("cluck"));
        System.out.println(f2.apply("cluck"));

        // BiFunction
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(bf1.apply("Iran", "Tehran"));
        System.out.println(bf2.apply("Italy", "Roma"));

        //
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("yazd"));
        System.out.println(u2.apply("yazd"));

        //
        BinaryOperator<String> bb1 = String::concat;
        BinaryOperator<String> bb2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(bb1.apply("a ", "b"));
        System.out.println(bb2.apply("c ", "d"));

    }
}

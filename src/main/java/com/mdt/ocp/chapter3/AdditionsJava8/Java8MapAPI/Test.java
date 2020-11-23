package com.mdt.ocp.chapter3.AdditionsJava8.Java8MapAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");

        favorites.put("Jenny", "Tram");
        System.out.println(favorites);
        //
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", null);

        favorites2.putIfAbsent("Jenny", "Yazd");
        favorites2.putIfAbsent("Sam", "Yazd");
        favorites2.putIfAbsent("Tom", "Yazd");
        System.out.println(favorites2);
        // merge
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites3 = new HashMap<>();
        favorites3.put("Jenny", "Bus Tour");
        favorites3.put("Tom", "Tram");

        String jenny = favorites3.merge("Jenny", "Skyride", mapper);
        String tom = favorites3.merge("Tom", "Skyride", mapper);

        System.out.println(favorites3);
        System.out.println(jenny);
        System.out.println(tom);
        //
        Map<String, String> favorites4 = new HashMap<>();
        favorites4.put("Sam", null);

        favorites4.merge("Tom", "Skyride", mapper);
        favorites4.merge("Sam", "Skyride", mapper);

        System.out.println(favorites4);

        //
        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;

        Map<String, String> favorites5 = new HashMap<>();
        favorites5.put("Tom", "1");
        favorites5.put("Jenny", "2");

        favorites5.merge("Jenny", "a", mapper2);
        favorites5.merge("Sam", "4", mapper2);
        System.out.println(favorites5);

        // computeIfPresent
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        BiFunction<String, Integer, Integer> mapper3 = (k, v) -> v + 1;
        Integer jenny2 = counts.computeIfPresent("Jenny", mapper3);
        Integer sam = counts.computeIfPresent("Sam", mapper3);
        System.out.println(counts); // {Jenny=2}
        System.out.println(jenny2); // 2
        System.out.println(sam); // null

        // computeIfAbsent
        Map<String, Integer> counts2 = new HashMap<>();
        counts2.put("Jenny", 15);
        counts2.put("Tom", null);
        Function<String, Integer> mapper4 = (k) -> 1;
        Integer jenny3 = counts2.computeIfAbsent("Jenny", mapper4); // 15
        Integer sam3 = counts2.computeIfAbsent("Sam", mapper4); // 1
        Integer tom3 = counts2.computeIfAbsent("Tom", mapper4); // 1
        System.out.println(counts2); // {Tom=1, Jenny=15, Sam=1} // interesting thing, it added the key to the map, not just compute

        //
        Map<String, Integer> stringLength = new HashMap<>();
        stringLength.put("John", 5);
        System.out.println((long)stringLength.computeIfAbsent("John", s -> s.length()));
        System.out.println((long)stringLength.computeIfAbsent("Ali", s -> s.length()));
        System.out.println(stringLength);

        //
        Map<String, Integer> counts3 = new HashMap<>();
        counts3.put("Jenny", 1);
        counts3.computeIfPresent("Jenny", (k, v) -> null);
        counts3.computeIfAbsent("Sam", k -> null);
        System.out.println(counts3); // {}
    }
}

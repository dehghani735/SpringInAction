package com.mdt.FunctionalAndReactive.M14_Collections.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MapFunctionalOperations {

    public static void main(String[] args) {

        Map<String, String> contacts = new HashMap<>();
        contacts.put("123", "John");
//        contacts.put("123", "John");
        contacts.put("1234", "John");
        contacts.put("723", "Neal");
        contacts.put("523", "Raju");
        contacts.put("999", "Peter");
        contacts.put("908", "Neha");

        // traversal
        contacts.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("--------------");

        // filter
        Map<String, String> filteredContacts = contacts.entrySet().stream()
                .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));
//                .forEach(System.out::println);

        // Map
        String contactNames = contacts.entrySet().stream()
                .distinct()
                .map(c -> c.getValue())
                .collect(Collectors.joining(" , "));
        System.out.println(contactNames);
        System.out.println("--------------");

        // sorting
        LinkedHashMap<String, String> sortedMap = contacts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue(), (v1, v2) -> v1, LinkedHashMap::new)); // TODO I don't understand the merge case
        sortedMap.forEach((k, v) -> System.out.println(k + " - " + v));
        System.out.println("--------------");

        // reduce
        HashMap<Object, Object> marks = new HashMap<>();
        marks.put("Science", 66.00);
        marks.put("Maths", 76.00);
        marks.put("English", 90.00);

        OptionalDouble average = marks.values().stream()
                .mapToDouble(m -> (double) m)
                .average();
        System.out.println(average.getAsDouble());

    }
}

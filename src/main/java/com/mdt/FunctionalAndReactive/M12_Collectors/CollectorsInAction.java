package com.mdt.FunctionalAndReactive.M12_Collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsInAction {

    public static void main(String[] args) {

        Path path = Paths.get("/dd");
        try (Stream<String> lines = Files.lines(path);) {
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
//            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);
            // TODO watch video to complete spliterator

            var employeeList = List.of(new Employee(3, "s", 'c', Date.from(Instant.now()), "yazd", "ss", Date.from(Instant.now()), 4.5));
            var employeesSorted = employeeList.stream().collect(Collectors.toCollection(TreeSet::new)); // Treeset tries to sort employees, but employees are
            // not comparible -> must implement compareto


            Map<Boolean, List<Employee>> partitionedData = employeeList.stream()
                    .collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));

            var maleEmployees = partitionedData.get(true);
            var femaleEmployees = partitionedData.get(false);

            Map<String, List<Employee>> getByDesignation = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(e -> e.getDesignation())
                    );
            System.out.println(getByDesignation);

            var employeeNamesString = employeeList.stream()
                    .map(e -> e.getName())
                    .collect(Collectors.joining(", "));
            System.out.println(employeeNamesString);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

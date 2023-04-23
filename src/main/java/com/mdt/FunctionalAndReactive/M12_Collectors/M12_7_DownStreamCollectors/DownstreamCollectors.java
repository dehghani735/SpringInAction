package com.mdt.FunctionalAndReactive.M12_Collectors.M12_7_DownStreamCollectors;

import com.mdt.FunctionalAndReactive.M12_Collectors.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DownstreamCollectors {

    public static void main(String[] args) {

        Path path = Paths.get("/dd");
        try (Stream<String> lines = Files.lines(path);) {
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
//            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);


            var employeeList = List.of(new Employee(3, "s", 'c', Date.from(Instant.now()), "yazd", "ss", Date.from(Instant.now()), 4.5));

            Map<String, Long> countByDesignation = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(e -> e.getDesignation(),
                                    Collectors.counting())
                    );
            System.out.println(countByDesignation);

            Map<String, Double> fundDistribution = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            e -> e.getDesignation(),
                            Collectors.summingDouble(e -> e.getSalary())
                    ));
            System.out.println(fundDistribution);

            Map<String, Optional<Employee>> maxSalaryEmployees = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            e -> e.getDesignation(),
                            Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))
                    ));
            System.out.println(fundDistribution);

            Map<String, Optional<Double>> maxSalaries = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            e -> e.getDesignation(),
                            Collectors.mapping(e -> e.getSalary(),
                                    Collectors.maxBy(Comparator.comparing(Function.identity())))
                    ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

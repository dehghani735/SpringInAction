package com.mdt.ocp.Additionals.Optionals;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.slf4j.Logger;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

public class TestOptional {
    private static final Logger log = getLogger(TestOptional.class);
    private List<String> names = Arrays.asList("mdt", "ali", "younes", "a", "b");

    public String getRandomName() {
        log.info("getRandomName() method - start");

        Random random = new Random();
        int index = random.nextInt(5);

        log.info("getRandomName() method - end");
        return names.get(index);
    }

    public String concatenate(String one, String two){
        return one + two;
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public String orElseBenchmark() {
//        return Optional.of("baeldung").orElse(getRandomName());
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public String orElseGetBenchmark() {
//        return Optional.of("baeldung").orElseGet(() -> getRandomName());
//    }

    public static void main(String[] args) {
        TestOptional test = new TestOptional();
        String name = Optional.of("baeldung")
                .orElse(test.getRandomName());
        System.out.println(name);


        String name2 = Optional.of("baeldung")
                .orElseGet(() -> test.getRandomName());

        System.out.println(name2);

    }
}

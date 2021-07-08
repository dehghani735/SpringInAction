package com.mdt.ocp.chapter4.ReturnOptional;

import java.util.Optional;

public class Test {
    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average()); // Optional.empty

        //
        Optional<Double> opt = average(90, 100);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
        //don't check
        Optional<Double> opt1 = average();
//        System.out.println(opt1.get()); // java.util.NoSuchElementException

        //
        String value = "f";
        Optional o = (value == null) ? Optional.empty() : Optional.of(value);
        Optional o2 = Optional.ofNullable(value);

        System.out.println(o);

        //
        Optional<Double> opt3 = average(90, 100);
        opt3.ifPresent(System.out::println);
        //
        System.out.println("from here");
        Optional<Double> opt4 = average();
        System.out.println(opt4.orElse(Double.NaN));
        System.out.println(opt4.orElseGet(() -> Math.random()));
//        System.out.println(opt4.orElseThrow(() -> new IllegalStateException()));


        Optional<String> s = Optional.of("test");
        System.out.println(Optional.of("TEST") + " " + s.map(String::toUpperCase));

        //
        var x1 = Optional.of(Optional.of("STRING"));
        var x2 = Optional.of("string").map(s1 -> Optional.of("STRING"));
        System.out.println(x1);
        System.out.println(x2);

        var y1 = Optional.of("STRING");
        var y2 = Optional
            .of("string")
            .flatMap(s3 -> Optional.of("STRING"));
        System.out.println(y1);
        System.out.println(y2);
    }
}

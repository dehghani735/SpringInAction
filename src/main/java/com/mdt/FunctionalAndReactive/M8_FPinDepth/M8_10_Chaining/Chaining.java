package com.mdt.FunctionalAndReactive.M8_FPinDepth.M8_10_Chaining;

import java.util.function.Function;

public class Chaining {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = s -> System.out.println(s);

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Hello");

        Consumer<String> c4 = c1.thenAccept(c2);
//        Consumer<String> c5 = c1.thenAccept(null); // null pointer exception
        c4.accept("BasicsStrong");

        Function<Integer, Integer> f1 = s -> s + 2;
        Function<Integer, Integer> f2 = s -> s * 2;
        var f3 = f1.andThen(f2);
        System.out.println(f3.apply(10));
    }
}

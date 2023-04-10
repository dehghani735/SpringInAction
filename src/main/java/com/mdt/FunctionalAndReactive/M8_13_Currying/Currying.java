package com.mdt.FunctionalAndReactive.M8_13_Currying;

import java.util.function.Function;

public class Currying {

    public static void main(String[] args) {

        Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;

        Function<Integer, Integer> fun2 = fun1.apply(1);

        Integer sum = fun2.apply(2);

        System.out.println(sum);

        var sum2 = fun1.apply(1).apply(2);
        System.out.println(sum2);

        var sum3 = fun2.apply(6); // we reuse fun2 multiple times -> it's good in multi-parameter functions
    }
}

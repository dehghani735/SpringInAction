package com.mdt.ocp.chapter3.AdditionsJava8.LoopoingCollection;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> cats = Arrays.asList("pishy", "karakal");
        for (String s : cats)
            System.out.print(s);

        cats.forEach(s -> System.out.print(s));
        cats.forEach(System.out::print);
    }
}

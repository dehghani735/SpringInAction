package com.mdt.ocp.chapter3.Generics.Bounds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void printList(List<?> list) {  // Unbounded Wildcards
        for (Object x: list) System.out.println(x);
    }
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
//        Number   Int
//        Integer

        List<? extends Number> list = new ArrayList<Integer>();

        List<? super IOException> exceptions = new ArrayList<Exception>();
//        exceptions.add(new Exception());
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }
}

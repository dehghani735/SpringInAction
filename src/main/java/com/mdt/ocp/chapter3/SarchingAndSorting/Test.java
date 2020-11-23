package com.mdt.ocp.chapter3.SarchingAndSorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Hoppy");
        System.out.println(index); // Since the list is in ascending order, we don’t meet the precondition
        // for doing a search.
    }
}

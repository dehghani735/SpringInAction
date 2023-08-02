package com.mdt.ocp.chapter3.JavaCollectionsFramework.HashInterface;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66);
        boolean b2 = set.add(10);
        boolean b3 = set.add(66);
        boolean b4 = set.add(8);
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);
        for (Integer integer : set)
            System.out.print(integer + ","); // prints the elements of the set in an arbitrary order
        System.out.println("");
        Set<Integer> set2 = new TreeSet<>();
        boolean b5 = set2.add(66);
        boolean b6 = set2.add(10);
        boolean b7 = set2.add(66);
        boolean b8 = set2.add(8);
        for (Integer integer : set2) System.out.print(integer + ", ");

        System.out.println("");
        NavigableSet<Integer> set3 = new TreeSet<>();
        for (int i = 0; i <= 20; i++)
            set3.add(i);
        System.out.println(set3.lower(10)); // 9
        System.out.println(set3.floor(10)); // 10
        System.out.println(set3.ceiling(20)); // 10
        System.out.println(set3.higher(20)); // 10
    }
}

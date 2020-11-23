package com.mdt.ocp.chapter3.SarchingAndSorting;

import com.mdt.ocp.chapter3.ComparableAndComparator.Duck;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {
    static class Rabbit {int id;}

    public static void main(String[] args) {
        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles", 7));
        Set<Rabbit> rabbit = new TreeSet<>();
        rabbit.add(new Rabbit()); // throws an exception; Java works this way for consistency.

        Set<Rabbit> rabbit2 = new TreeSet<>(new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                return o1.id - o2.id;
            }
        });
        rabbit2.add(new Rabbit());
    }
}

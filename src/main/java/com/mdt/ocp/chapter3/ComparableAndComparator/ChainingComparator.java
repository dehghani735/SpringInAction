package com.mdt.ocp.chapter3.ComparableAndComparator;

import java.util.Comparator;

// with the aim of java 8; with static and default methods, it's easier to compare multiple fields
public class ChainingComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies()); // static method
        c = c.thenComparingInt(s -> s.getWeight()); // default method
        return c.compare(s1, s2);
    }
}

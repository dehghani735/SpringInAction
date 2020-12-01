package com.mdt.ocp.chapter3.SearchingAndSorting;

import java.util.*;

public class SortRabbits {
    static class Rabbit {int id;}

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
//        Collections.sort(rabbits); // Java knows that the Rabbit class is not Comparable
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
    }
}

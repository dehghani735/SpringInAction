package com.mdt.FunctionalAndReactive.M11_.M11_3_Characteristics;

import java.util.ArrayList;
import java.util.Spliterator;

public class Characteristics {

    public static void main(String[] args) {

        var list = new ArrayList<Integer>();
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(0);
        list.add(1);

        var stream = list.stream();
        Spliterator<Integer> spliterator = stream.spliterator();
        int bits = spliterator.characteristics();
        System.out.println(Integer.bitCount(bits)); // represents how many properties are set

        // OR
        System.out.println(Integer.bitCount(bits | 0x00000010));

        // AND
        System.out.println(bits & 0x00000010);
        System.out.println(spliterator.hasCharacteristics(0x00000010));
    }
}

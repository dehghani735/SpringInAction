package com.mdt.ocp.chapter3.OCACollections.WrapperAutoboxing;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(new Integer(3));
        numbers.add(new Integer(5));
        numbers.remove(1); // one overload (index to remove)
        numbers.remove(new Integer(5)); // another overload (object to be removed)
        System.out.println(numbers);

        int num = numbers.get(0); // unboxing
    }
}

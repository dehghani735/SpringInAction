package com.mdt.ocp.chapter3.OCACollections.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // empty list
        list.add("Fluffy");
        list.add("Webby");

        String[] array = new String[list.size()]; // empty array
        array[0] = list.get(0);
        array[1] = list.get(1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "-");
        }
        //-----------

        String[] array1 = {"gerbil", "mouse"}; // [gerbil, mouse]
        List<String> list1 = Arrays.asList(array1); // returns fixed size list
        // At you can change the elements in either the array or the List. Changes are reflected in both,
        // since they are backed by the same data.
        list1.set(1, "test"); // [gerbil, test]
        array1[0] = "new"; // [new, test]
        String[] array2 = (String[]) list1.toArray(); // [new, test] => TODO it has Exception and I don't know why

        //list1 is not resizable because it is backed by the underlying array.
        list1.remove(1); // throws UnsupportedOperationException.
    }
}
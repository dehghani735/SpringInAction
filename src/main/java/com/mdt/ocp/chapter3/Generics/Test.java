package com.mdt.ocp.chapter3.Generics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add(new StringBuilder("Webby"));
        printNames(names); // run-time error

        List<String> names2 = new ArrayList<String>();
//        names2.add(new StringBuilder("Webby")); // DOES NOT COMPILE
    }

    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // class cast exception here
            System.out.println(name);
        }
    }
}

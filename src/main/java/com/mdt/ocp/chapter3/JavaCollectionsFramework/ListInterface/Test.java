package com.mdt.ocp.chapter3.JavaCollectionsFramework.ListInterface;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        List
//        Set
//        Queue
        List<String> birds = new ArrayList<>();
        System.out.println(birds.add("hawk"));
        birds.add("hawk");
        System.out.println(birds.remove("cardinal"));
        System.out.println(birds.remove("hawk"));
        System.out.println(birds);
//        birds.remove(100);
        birds.remove("hawk");

        System.out.println(birds.isEmpty()); // true
        System.out.println(birds.size()); // 0

        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.isEmpty()); // false
        System.out.println(birds.size()); // 2
        //-------------------
        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk"); // [hawk]
        birds2.add("hawk"); // [hawk, hawk]
        System.out.println(birds2.isEmpty()); // false
        System.out.println(birds2.size()); // 2
        System.out.println("contains: " + birds2.contains("hawk"));
        birds2.clear(); // []
        System.out.println(birds2.isEmpty()); // true
        System.out.println(birds2.size()); // 0
    }
}

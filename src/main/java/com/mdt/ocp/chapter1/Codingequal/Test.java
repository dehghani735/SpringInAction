package com.mdt.ocp.chapter1.Codingequal;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object obj) {
        if (! (obj instanceof Test)) return false;
        Test t = (Test) obj;
        return name.equals(t.name);
    }

    @Override public int hashCode() {

        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);
//        int rand_int2 = rand.nextInt(1000);
//        int hash = (int) Math.random();
        System.out.println(rand_int1);
//        return rand_int1;
        return 34;
    }

    public static void main(String[] args) {
        Set<Test> myset = new HashSet<>();

        Test t1 = new Test("salam");
        Test t2 = new Test("salam");
        if (t1.equals(t2))
            System.out.println("equal");
        myset.add(t1);
        myset.add(t2);

        System.out.println(myset.size());
    }
}

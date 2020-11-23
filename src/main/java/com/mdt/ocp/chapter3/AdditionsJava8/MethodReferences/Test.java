package com.mdt.ocp.chapter3.AdditionsJava8.MethodReferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        // static method
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

        // calling an instance method on a specific instance
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);
        // tricky one; we call an instance method without knowing the instance in advance
        // Instance methods on an instance to be determined at runtime
        Predicate<String> methodRef3 = s -> s.isEmpty();
        Predicate<String> lambda3 = String::isEmpty;
        // constructor reference
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();
    }
}

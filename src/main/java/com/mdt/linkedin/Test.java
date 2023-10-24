package com.mdt.linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/static-method-in-interface-in-java/
 *
 */
public class Test {

    interface Interface1 {
        static void print() {
            System.out.print("Hello");
        }
    }

    interface Interface2 {
        static void print() {
            System.out.print("World!");
        }
    }

    interface One {
        default void method() {
            System.out.println("One");
        }
    }

    interface Two {
        default void method () {
            System.out.println("One");
        }
    }

//    class Three implements One, Two {
//        public void method() {
//            One.method();
//        }
//    }

    public static void main(String[] args) {
//        Interface1.print(); Interface2.print();
//
//
//        String str = "abcde";
//        str.trim();
//        str.toUpperCase();
//        str.substring(3, 4);
//        System.out.println(str);
//
//        List list = new ArrayList();
//        list.add("hello");
//        list.add(2);
//        System.out.print(list.get(0) instanceof Object);
//        System.out.print(list.get(1) instanceof Integer);

        System.out.println("salam");

    }

    
}

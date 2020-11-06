package com.mdt.ocp.chapter1.NestedClasses.StaticNested;

public class Enclosing {
    static class Nested {
        private int price = 6;
    }

    public static void main(String[] args) {
        // Since the class is static, you do not need an instance of Enclosing in order to use it.
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}

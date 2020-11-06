package com.mdt.ocp.chapter1.cat;

abstract class Cat {
    String name = "The Cat";

    //    one way let it blank
//    one way
//    abstract void Clean();
//    default implementation
    static void Clean() {
    }
}

class Lion extends Cat {
    static void Clean() {
    }

    public static void main(String[] args) {

    }
}

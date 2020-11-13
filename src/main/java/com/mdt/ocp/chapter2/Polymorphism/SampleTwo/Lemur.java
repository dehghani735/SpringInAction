package com.mdt.ocp.chapter2.Polymorphism.SampleTwo;

public class Lemur extends Primate implements HasTail {
    public int age = 10;
    public boolean isTailStriped() {
        return false;
    }
    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);
        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());
//        System.out.println(hasTail.age); // Does not compile due to note
        Primate primate = lemur;
        System.out.println(primate.hasHair());
//        System.out.println(primate.isTailStriped); // Does not compile due to note
    }
}

// note: If you use a variable to refer to an object, then only the methods or variables that are part
// of the variable’s reference type can be called without an explicit cast.
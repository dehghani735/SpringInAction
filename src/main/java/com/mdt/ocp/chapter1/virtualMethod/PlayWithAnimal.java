package com.mdt.ocp.chapter1.virtualMethod;

public class PlayWithAnimal {
    public static void main(String... args) {
        Animal animal = new Lion();
        animal.printName();

        animal.careFor(); // Java looks for overridden methods
    }
}

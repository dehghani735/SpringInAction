package com.mdt.ocp.chapter2.FunctionalProgramming;

public class Tiger implements Sprint {
    @Override
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! " + animal.toString());
    }
}

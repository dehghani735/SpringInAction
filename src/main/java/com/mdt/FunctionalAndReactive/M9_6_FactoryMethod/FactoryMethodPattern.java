package com.mdt.FunctionalAndReactive.M9_6_FactoryMethod;

public class FactoryMethodPattern {

    public static void main(String[] args) {

        Flooring floor = FlooringFactory.getFlooring(-1, 18); // we don't know which object we are going to get
        floor.installation();
    }
}

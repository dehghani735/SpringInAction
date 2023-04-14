package com.mdt.FunctionalAndReactive.M9_DesignPatterns.M9_4_Decorator;

public class Burger {

    private String burgerType;

    // set burger with no decoration
    public Burger() {
        this.burgerType = "";
    }

    // only to be used inside this class
    private Burger(String type) {
        this.burgerType = type;
    }

    // modify the functionality or to add decorations
    public Burger addVeggies() {
        System.out.println("Adding veggies to the burger");

        return new Burger(this.burgerType += " Veggie"); // returns the fresh instance of the burger class. we could modified the same instance,
        // but in FP we don't modify the object's state
    }

    public Burger addCheese() {
        System.out.println("Adding cheese to the burger");

        return new Burger(this.burgerType += " Cheese");
    }

    public String toString() {
        return String.format("%s", burgerType + " burger");
    }
}

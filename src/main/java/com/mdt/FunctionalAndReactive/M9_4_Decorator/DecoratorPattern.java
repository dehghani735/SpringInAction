package com.mdt.FunctionalAndReactive.M9_4_Decorator;

public class DecoratorPattern {

    public static void main(String[] args) {
        var myOrder = new BurgerShop(burger -> burger.addCheese())
                .use(
                        new BurgerShop(burger -> burger.addVeggies())
                                .use(new Burger()
                                )
                );

        System.out.println("I get " + myOrder);
    }
}

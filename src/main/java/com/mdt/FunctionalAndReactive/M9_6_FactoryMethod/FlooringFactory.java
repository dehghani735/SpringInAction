package com.mdt.FunctionalAndReactive.M9_6_FactoryMethod;

import java.util.function.Supplier;

public class FlooringFactory {

    public static Flooring getFlooring(int minTemprature, int maxTemperature) {

        Supplier<Flooring> flooring;

        if (minTemprature <= 5 && maxTemperature <= 20)
            flooring = () -> new WoodenFlooring();
        else if (minTemprature <= 5 && maxTemperature >= 45)
            flooring = () -> new CorkFlooring();
        else
            flooring = () -> new ConcreteFlooring();

        return flooring.get();
    }
}

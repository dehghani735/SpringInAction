package com.mdt.FunctionalAndReactive.M8_FPinDepth.M8_6_HigherOrderFunctions;

public class HigherOrderFunctions {
    public static void main(String[] args) {

        var createFactory = createFactory(() -> Math.random() * 100, r -> r.intValue());
        var product = createFactory.create();
        System.out.println(product);
    }

    // Note: why return type is an interface? because this interface is a functionalInterface and
    // we can implement it with lambda. so actually the return type is a function.
    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {

        return () -> {
            var product = producer.produce();
            return configurator.configure(product);
        };
    }
}

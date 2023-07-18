package com.mdt.FunctionalAndReactive.M8_FPinDepth.M8_11_Composition;

public class FunctionalComposition {

    public static void main(String[] args) {

        Function<Square, Integer> fun1 = s -> s.getArea();
        Function<Integer, Double> fun2 = area -> Math.sqrt(area);

        var getSide = fun2.compose(fun1);

        Square s = new Square();
        s.setArea(100);
        var side = getSide.apply(s);
        System.out.println(side);
    }
}

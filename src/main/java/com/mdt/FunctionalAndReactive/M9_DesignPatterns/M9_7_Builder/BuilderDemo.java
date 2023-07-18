package com.mdt.FunctionalAndReactive.M9_DesignPatterns.M9_7_Builder;

public class BuilderDemo {

    public static void main(String[] args) {

        MobileBuilder builder = new MobileBuilder();
        Mobile myMobile = builder.with(myBuilder -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A12 Bionic";
        }).createMobile();  // no need to define multiple constructors. we can define default fields.

        System.out.println(myMobile);
    }
}

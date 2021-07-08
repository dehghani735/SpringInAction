package com.mdt.ocp.chapter1.NestedClasses.AnonymousInner;

public class AnonInnerInterface {
    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sales = new SaleTodayOnly() {
            public int dollarsOff() { // public access modifier is important
                return 3;
            }
        };
        return basePrice - sales.dollarsOff();
    }

    public static void main(String[] args) {
        AnonInnerInterface anonInner = new AnonInnerInterface();
        System.out.println(anonInner.admission(50));
    }
}

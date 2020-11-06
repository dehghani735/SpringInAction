package com.mdt.ocp.chapter1.NestedClasses.AnonymousInner;

public class AnonInner {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sales = new SaleTodayOnly() {
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sales.dollarsOff();
    }

    public static void main(String[] args) {
        AnonInner anonInner = new AnonInner();
        System.out.println(anonInner.admission(50));
    }
}

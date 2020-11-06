package com.mdt.ocp.chapter1.NestedClasses.AnonymousInner;

public class AnonInnerParameter {
    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice, SaleTodayOnly saleTodayOnly) {
        return basePrice - saleTodayOnly.dollarsOff();
    }

    public int pay() {
        return admission(5, new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        });
    }

    public static void main(String[] args) {
        AnonInnerParameter anonInnerParameter = new AnonInnerParameter();
        System.out.println(anonInnerParameter.pay());
    }
}

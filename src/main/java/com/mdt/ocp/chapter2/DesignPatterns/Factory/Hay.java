package com.mdt.ocp.chapter2.DesignPatterns.Factory;

public class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }
}

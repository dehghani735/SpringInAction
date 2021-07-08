package com.mdt.ocp.chapter2.DesignPatterns.Factory;

public class ZooKeeper {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}

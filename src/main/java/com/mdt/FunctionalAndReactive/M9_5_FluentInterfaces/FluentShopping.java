package com.mdt.FunctionalAndReactive.M9_5_FluentInterfaces;

public class FluentShopping {

    public static void main(String[] args) {

        // method 1
//        Order myOrder = new Order();
//        myOrder.add("Shoes");
//        myOrder.add("Headphones");
//        myOrder.deliverAt("Street no 8, salsabil");
//
//        myOrder.place();

        // method 2
//        new Order()
//                .add("Shoes")
//                .add("Headphones")
//                .deliverAt("Street no 8, salsabil")
//                .place();

        // method 3: more elegant, more concise
        Order.place(order -> order.add("Shoes")
                .add("Headphones")
                .deliverAt("Street no 8, salsabil"));

    }
}

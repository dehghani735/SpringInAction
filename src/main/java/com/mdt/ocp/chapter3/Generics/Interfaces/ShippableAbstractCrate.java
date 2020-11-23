package com.mdt.ocp.chapter3.Generics.Interfaces;

class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) {
    }
}
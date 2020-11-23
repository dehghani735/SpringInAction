package com.mdt.ocp.chapter3.Generics.Interfaces;

public interface Shippable<T> {
    void ship(T t);
}
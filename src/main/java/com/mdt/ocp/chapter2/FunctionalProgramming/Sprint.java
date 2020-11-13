package com.mdt.ocp.chapter2.FunctionalProgramming;

/**
 * the Sprint class is a functional interface, because it contains exactly
 * one abstract method
 */
@FunctionalInterface
public interface Sprint {
    public void sprint(Animal animal);
}

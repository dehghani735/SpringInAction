package com.mdt.ocp.chapter3.Generics.Classes;

public class Zebra {
    public static void main(String[] args) {
        Zebra zebra = new Zebra();
        Crate<Zebra> crateForZebra = new Crate<>();
        crateForZebra.packCrate(zebra);
        Zebra inNewHome = crateForZebra.emptyCrate();
    }
}
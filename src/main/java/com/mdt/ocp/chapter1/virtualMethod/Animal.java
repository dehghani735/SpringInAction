package com.mdt.ocp.chapter1.virtualMethod;

abstract class Animal {
    public String name = "???";

    public abstract void feed();

    public void printName() {
        System.out.println(name); // it is referred from Animal not Lion
    }

    public void careFor() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }
}

class Cow extends Animal {
    public void feed() {
        addHay();
    }

    private void addHay() {
    }
}

class Bird extends Animal {
    public void feed() {
        addSeed();
    }

    private void addSeed() {
    }
}

class Lion extends Animal {

    public String name = "Leo";

    public void feed() {
        addMeat();
    }

    private void addMeat() {
    }

    public void play() {
        System.out.println("toss in meat");
    }
}

package com.mdt.ocp.chapter1.overriden;

class Bobcat {
    public void findDen() {}
}

class BobcatMother extends Bobcat {
    @Override public void findDen() {
    }
}
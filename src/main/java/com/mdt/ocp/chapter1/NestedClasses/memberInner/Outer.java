package com.mdt.ocp.chapter1.NestedClasses.MemberInner;

public class Outer {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;
        public void go(){
            for (int i = 0; i<repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();

        Outer outer1 = new Outer();
        Inner inner1 = outer1.new Inner();
        inner1.go();
    }
}

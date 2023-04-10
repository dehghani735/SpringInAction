package com.mdt.ocp.chapter1.NestedClasses.MemberInner;

public class A {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void printAllX() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(A.this.x);
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = a.new B();
        B.C c = b.new C(); // C is too deep for Java to know where to look => B.C
        c.printAllX();
    }
}

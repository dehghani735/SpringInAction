package com.mdt.ocp.chapter1;

public class Hippo extends HeavyAnimal {

    public static void main(String[] args) {
        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo;
        boolean b2 = hippo instanceof HeavyAnimal;
        boolean b3 = hippo instanceof Elephant;
        System.out.println(b1 + "," + b2 + "," + b3);

        // null is not Object
        boolean b4 = hippo instanceof Object;
        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object;
        System.out.println(b4 + "," + b5);

        Hippo anotherHippo = new Hippo();
//        boolean b6 = anotherHippo instanceof Elephant; // DOES NOT COMPILE

        boolean b7 = hippo instanceof Mother;
        System.out.println(b7);
    }
}

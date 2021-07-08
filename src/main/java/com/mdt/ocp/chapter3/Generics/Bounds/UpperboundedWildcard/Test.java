package com.mdt.ocp.chapter3.Generics.Bounds.UpperboundedWildcard;

import java.util.ArrayList;
import java.util.List;

class Sparrow extends Bird {
}

class Bird {
}

public class Test {
    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
//        birds.add(new Sparrow());     // DOES NOT COMPILE
//        birds.add(new Bird());        // DOES NOT COMPILE

//        Number
//        Integer
    }
}

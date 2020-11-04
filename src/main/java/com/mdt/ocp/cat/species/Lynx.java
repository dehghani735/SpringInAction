package com.mdt.ocp.cat.species;

import com.mdt.ocp.cat.BigCat;

public class Lynx extends BigCat {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
//        System.out.println(cat.hasFur); it is being accessed via the variable rather than by inheritance
//        System.out.println(cat.hasPaws);
//        System.out.println(cat.id);
        Lynx cat2 = new Lynx();
        System.out.println(cat2.hasFur);
    }
}

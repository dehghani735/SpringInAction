package com.mdt.ocp.chapter1.cat;

public class CatAdmirer {
    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        System.out.println(cat.hasFur);
        System.out.println(cat.hasPaws); // same package ok
//        System.out.println(cat.id);
    }
}

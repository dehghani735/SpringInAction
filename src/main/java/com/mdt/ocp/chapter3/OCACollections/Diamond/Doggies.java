package com.mdt.ocp.chapter3.OCACollections.Diamond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Doggies {
    List<String> names;

    Doggies() {
        names = new ArrayList<>(); // matches instance variable declaration
    }

    public void copyNames() {
        ArrayList<String> copyOfNames;
        copyOfNames = new ArrayList<>(); // matches local variable declaration
    }

    public static void main(String[] args) {

        HashMap<String, HashMap<String, String>> map1 =
                new HashMap<String, HashMap<String, String>>();

        HashMap<String, HashMap<String, String>> map2 = new HashMap<>();

        // these two above declarations are same. for readability, the second one is better using <> (diamond) operator.
    }
}
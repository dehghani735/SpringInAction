package com.mdt.ocp.chapter3.JavaCollectionsFramework.MapNotCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala");
        for (String key : map.keySet())
            System.out.print(key + ",");

        System.out.println("");

        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        String food2 = map2.get("koala"); // bamboo
        for (String key : map2.keySet())
            System.out.print(key + ","); // giraffe,koala,lion,

//        System.out.println(map2.contains("lion")); // DOES NOT COMPILE
        System.out.println(map2.containsKey("lion")); // true
        System.out.println(map2.containsValue("lion")); // false
        System.out.println(map2.size()); // 3
    }
}

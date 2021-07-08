package com.mdt.ocp.chapter7.ConcurrentCollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
//      Map<String, Object> foodData = new HashMap<String, Object>(); // this would be throw ConcurrentModificationException at runtime
        Map<String, Object> foodData = new ConcurrentHashMap<>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);

        System.out.println(foodData.keySet());
        for (String key : foodData.keySet())
            foodData.remove(key);
    }
}

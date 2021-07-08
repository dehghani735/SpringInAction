package com.mdt.ocp.chapter7.ConcurrentCollections;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(
            new ArrayList<>(Arrays.asList(4, 3, 52)));
        synchronized (list) {
            for (int data : list)
                System.out.print(data + " ");
        }

        //
        Map<String, Object> foodData = new HashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
        for (String key : synchronizedFoodData.keySet())
            synchronizedFoodData.remove(key);
    }
}

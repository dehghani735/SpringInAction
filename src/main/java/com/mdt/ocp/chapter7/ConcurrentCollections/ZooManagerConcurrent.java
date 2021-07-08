package com.mdt.ocp.chapter7.ConcurrentCollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManagerConcurrent {
    private Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();

    public void put(String key, String value) {
        foodData.put(key, value);
    }

    public Object get(String key) {
        return foodData.get(key);
    }
}

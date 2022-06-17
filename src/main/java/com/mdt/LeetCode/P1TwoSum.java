package com.mdt.LeetCode;

import java.util.HashMap;

public class P1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no match found");
    }
}

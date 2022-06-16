package com.mdt.LeetCode;

import java.util.HashMap;

/**
 * Easy
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * date: 6/16/22
 */
public class P136SingleNumber {

    /**
     * my solution, but not optimized and space complexity is O(n)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        var x = 0;
        for (var n : nums) {
            if (map.containsKey(n))
                x = map.remove(n);
            else
                map.put(n, n);
        }
        return map.keySet().stream().findFirst().get();
    }

    /**
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        var result = 0;

        for(var x: nums)
            result ^= x;

        return result;
    }
}
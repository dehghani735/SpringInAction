package com.mdt.LeetCode.Easy;

import java.util.HashSet;

/**
 * Easy
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * date: 6/7/22
 * <p>
 * Another solution: sort array, and check adjacent not to be equal.
 */
public class P217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        var mySet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            var alreadyContains = mySet.add(nums[i]);
            if (!alreadyContains)
                return true;
        }
        return false;
    }
}

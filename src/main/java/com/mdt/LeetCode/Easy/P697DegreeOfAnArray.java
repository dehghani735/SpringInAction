package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Easy
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency
 * of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as
 * nums
 * <p>
 * date: 7/07/22
 */
public class P697DegreeOfAnArray {

    /**
     * my solution. but Nick's solution has one for loop and it's simpler.
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        var dict = new HashMap<Integer, Integer>();

        for (var n : nums)
            dict.put(n, dict.getOrDefault(n, 0) + 1);

        var max = 0;
        for (var i : dict.keySet())
            if (dict.get(i) > max)
                max = dict.get(i);

        var maxDict = new HashMap<Integer, ArrayList<Integer>>();
        for (var i = 0; i < nums.length; i++) {
            if (dict.get(nums[i]) == max) {
                var x = maxDict.getOrDefault(nums[i], new ArrayList<>());
                x.add(i);
                maxDict.put(nums[i], x);
            }
        }

        var min = Integer.MAX_VALUE;
        for (var c : maxDict.keySet()) {
            var x = maxDict.get(c);
            var y = x.stream().sorted().toList();
            min = Math.min(y.get(y.size() - 1) - y.get(0) + 1, min);
        }

        return min;
    }
}

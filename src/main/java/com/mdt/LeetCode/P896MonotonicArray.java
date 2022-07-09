package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 * <p>
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 * <p>
 * date: 7/09/22
 */
public class P896MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        var increasing = true;
        for (var i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] >= nums[i])
                continue;
            else
                increasing = false;
        }
        if (!increasing) {
            for (var i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] <= nums[i])
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}

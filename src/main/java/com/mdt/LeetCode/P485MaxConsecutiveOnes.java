package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * date: 6/19/22
 */
public class P485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        var maxConsecutive = 0;

        var temp = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                maxConsecutive = Math.max(temp, maxConsecutive);
            } else temp = 0;
        }
        return maxConsecutive;
    }
}

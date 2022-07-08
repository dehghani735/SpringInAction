package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
 * <p>
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 * <p>
 * date: 7/08/22
 */
public class P674LongestContinuousIncreasingSubsequence {

    /**
     * my solution
     * O(n) time and space complexity.
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        var counts = new int[nums.length];
        for (var i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i])
                counts[i + 1] = counts[i] + 1;
            else
                counts[i + 1] = 0;
        }
        var max = 0;
        for (var c : counts)
            if (c > max)
                max = c;

        return max + 1;
    }

    /**
     * Nick's solution: O(1) space complexity
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        var result = 0;
        var anchor = 0;

        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
            result = Math.max(result, i - anchor + 1);
        }

        return result;
    }
}

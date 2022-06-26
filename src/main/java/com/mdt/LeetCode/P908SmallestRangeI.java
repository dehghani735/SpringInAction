package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.
 * <p>
 * The score of nums is the difference between the maximum and minimum elements in nums.
 * <p>
 * Return the minimum score of nums after applying the mentioned operation at most once for each index in it.
 * <p>
 * date: 6/26/22
 */
public class P908SmallestRangeI {

    /**
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {
        var minVal = nums[0];
        var maxVal = nums[0];

        for (var i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }

        if (minVal + k >= maxVal - k)
            return 0;
        else
            return (maxVal - k) - (minVal + k);
    }
}

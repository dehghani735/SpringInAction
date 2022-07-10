package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given an array of integers nums, calculate the pivot index of this array.
 * <p>
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * <p>
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * <p>
 * Return the leftmost pivot index. If no such index exists, return -1.
 * <p>
 * date: 6/27/22
 */
public class P724FindPivotIndex {

    /**
     * my solution, hooray
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        var sumFromStart = 0;
        var sumFromEnd   = 0;

        for (var num : nums)
            sumFromEnd += num;

        sumFromEnd -= nums[0];

        for (var i = 0; i < nums.length; i++) {
            if (sumFromStart == sumFromEnd)
                return i;

            sumFromStart += nums[i];
            if (i + 1 < nums.length)
                sumFromEnd -= nums[i + 1];
        }
        return -1;
    }
}

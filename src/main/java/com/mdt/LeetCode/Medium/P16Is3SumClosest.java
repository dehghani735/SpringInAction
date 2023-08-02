package com.mdt.LeetCode.Medium;

import java.util.Arrays;

/**
 * Medium
 * <p>
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
 * closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * date: 8/07/22
 */
public class P16Is3SumClosest {
    public static void main(String[] args) {
//        Input: nums = [-1,2,1,-4], target = 1
//        Output: 2
        // -3
        // [-4  -1  1  2]
    }

    /**
     * Nick's solution
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        var result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (var i = 0; i < nums.length - 2; i++) { // loop until two last elements
            var a_pointer = i + 1;
            var b_pointer = nums.length - 1; // always last element ( biggest element)

            while (a_pointer < b_pointer) {
                var current_sum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if (current_sum > target)
                    b_pointer -= 1;
                else
                    a_pointer += 1;

                if (Math.abs(current_sum - target) < Math.abs(result - target))
                    result = current_sum;
            }
        }

        return result;
    }
}

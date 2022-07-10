package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 * <p>
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 * <p>
 * Return any answer array that satisfies this condition.
 * <p>
 * date: 6/17/22
 */
public class P922SortArrayByParityII {

    /**
     * in-place solution
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        var i = 0;
        var j = 1;
        var n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0)
                i += 2;
            while (j < n && nums[j] % 2 == 1)
                j += 2;
            if (i < n && j < n) {
                var temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;
    }
}

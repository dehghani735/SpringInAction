package com.mdt.LeetCode;

import java.util.Arrays;

/**
 * Easy
 * <p>
 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 * <p>
 * date: 6/17/22
 */
public class P561ArrayPartitionI {

    /**
     * O(n logn) time complexity, O(n) for space complexity of sort algorithm
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        var sum = 0;
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    final static int K = 10000;

    /**
     * TODO: do it again, counting sort algorithm idea is useful here
     *
     * @param nums
     * @return
     */
    public int arrayPairSum2(int[] nums) {
        // Store the frequency of each element
        int[] elementToCount = new int[2 * K + 1];
        for (int element : nums) {
            // Add K to element to offset negative values
            elementToCount[element + K]++;
        }

        // Initialize sum to zero
        int     maxSum      = 0;
        boolean isEvenIndex = true;
        for (int element = 0; element <= 2 * K; element++) {
            while (elementToCount[element] > 0) {
                // Add element if it is at even position
                maxSum += (isEvenIndex ? element - K : 0);
                // Flip the value (one to zero or zero to one)
                isEvenIndex = !isEvenIndex;
                // Decrement the frequency count
                elementToCount[element]--;
            }
        }
        return maxSum;
    }
}

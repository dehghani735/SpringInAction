package com.mdt.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Easy
 * <p>
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * <p>
 * Return any array that satisfies this condition.
 * <p>
 * date: 6/16/22
 */
public class P905SortArrayByParity {

    /**
     * O(n) space complexity
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        var evens = IntStream.of(nums).filter(it -> it % 2 == 0);
        var odds  = IntStream.of(nums).filter(it -> it % 2 != 0);

        return IntStream.concat(evens, odds).toArray();
    }

    /**
     * O(n) time and O(n) space complexity
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity2(int[] nums) {
        var new_arr = new int[nums.length];
        var counter = 0;

        for (int num : nums)
            if (num % 2 == 0)
                new_arr[counter++] = num;

        for (int num : nums)
            if (num % 2 != 0)
                new_arr[counter++] = num;

        return new_arr;
    }

    /**
     * in-place solution
     * <p>
     * O(n) time, O(1) space complexity
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity3(int[] nums) {
        var i = 0;
        var j = nums.length - 1;

        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                var temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if (nums[i] % 2 == 0) i++;
            if (nums[j] % 2 != 0) j--;
        }
        return nums;
    }

    /**
     * Intuition and Algorithm:
     * Use a custom comparator when sorting, to sort by parity.
     * <p>
     * Time Complexity: O(NlogN), where N is the length of A.
     * space complexity O(n) depending on the built-in implementation of sort.
     * TODO: read more about comparator?
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity4(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(a -> a % 2)) // (a, b) -> Integer.compare(a % 2, b % 2)
                .mapToInt(i -> i)
                .toArray();
//        (a, b) -> Integer.compare(a % 2, b % 2) // see Integer.compare logic
    }
}

package com.mdt.LeetCode.Medium;

/**
 * Medium
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * date: 7/21/22
 */
public class P167TwoSumIIInputArrayIsSorted {

    /**
     * my solution
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (var i = 0; i < numbers.length; i++) {
            var index1 = numbers[i];
            var index2 = target - index1;
            var result = binarySearch(numbers, i + 1, numbers.length - 1, index2);
            if (result != -1)
                return new int[]{i + 1, result + 1};
        }
        return null;
    }

    int binarySearch(int[] numbers, int from, int to, int target) {
        while (from <= to) {
            int mid    = (from + to) >>> 1;
            int midVal = numbers[mid];

            if (midVal < target)
                from = mid + 1;
            else if (midVal > target)
                to = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not
    }

    /**
     * Nick's solution: it's very efficient
     * idea: two pointers, when the array is sorted, always think about two pointers
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        var aPointer = 0;
        var bPointer = numbers.length - 1;
        while (aPointer <= bPointer) {
            var sum = numbers[aPointer] + numbers[bPointer];
            if (sum < target)
                aPointer++;
            else if (sum > target)
                bPointer--;
            else
                return new int[]{aPointer + 1, bPointer + 1};
        }
        return new int[]{aPointer + 1, bPointer + 1};
    }
}

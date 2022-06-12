package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Let's call an array arr a mountain if the following properties hold:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * <p>
 * date: 6/12/22
 */
public class P852PeakIndexinaMountainArray {

    /**
     * runtime is O(n)
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        //var asc = true;
        for (var i = 0; i < arr.length; i++) {
            if (i != arr.length - 1 && arr[i] < arr[i + 1])
                continue;
            else
                return i;
        }
        return 0;
    }

    /**
     * O(log n) => much faster
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray2(int[] arr) {
        var left  = 0;
        var right = arr.length - 1;

        while (left < right) {
            var midPoint = left + (right - left) / 2;
            if (arr[midPoint] < arr[midPoint + 1])
                left = midPoint + 1;
            else
                right = midPoint;
        }
        return left;
    }
}

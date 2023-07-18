package com.mdt.LeetCode.Easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Easy
 * <p>
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * date: 6/23/22
 */
public class P496NextGreaterElementI {

    /**
     * nick's solution, nice one
     * <p>
     * TODO: solve it again, it was nice
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var nextGreater = new HashMap<Integer, Integer>();
        var stack       = new Stack<Integer>();

        for (var num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                nextGreater.put(stack.pop(), num);

            stack.push(num);
        }

        var result = new int[nums1.length];
        for (var i = 0; i < nums1.length; i++)
             result[i] = nextGreater.getOrDefault(nums1[i], -1);

        return result;
    }
}

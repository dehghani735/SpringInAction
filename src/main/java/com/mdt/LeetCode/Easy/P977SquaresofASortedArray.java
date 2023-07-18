package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * date: 6/11/22
 */
public class P977SquaresofASortedArray {

    /**
     * my solution: I made it complex
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        var stack      = new Stack<Integer>();
        var finalArray = new int[nums.length];
        var counter    = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                stack.push(nums[i]);
            else {
                if (!stack.isEmpty()) {
                    var topAbs = Math.abs(stack.peek());
                    if (nums[i] < topAbs)
                        finalArray[counter] = nums[i] * nums[i];
                    else {
                        var poped = stack.pop();
                        finalArray[counter] = Math.abs(poped * poped);
                        i--;
                    }
                } else
                    finalArray[counter] = nums[i] * nums[i];
                counter++;
            }
        }
        while (!stack.isEmpty()) {
            var popped = stack.pop();
            finalArray[counter++] = popped * popped;
        }
        return finalArray;
    }

    /**
     * nick's solution: idea: use two pointers one at the beginning of positive side and one at the beginning of negative side
     * TODO implement next time
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        return null;
    }
}

package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 * <p>
 * date: 7/04/22
 */
public class P414ThirdMaximumNumber {

    /**
     * my solution, has bugs, because I should use Integer instead of int and utilize null value of Integer.
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        var firstMax  = Integer.MIN_VALUE;
        var secondMax = Integer.MIN_VALUE;
        var thirdMax  = Integer.MIN_VALUE;
        var thirdSet  = false;

        for (var n : nums) {
            if (n >= firstMax) {
                if (n != firstMax) {
                    secondMax = firstMax;
                    firstMax  = n;
                }
            } else if (n >= secondMax) {
                if (n != secondMax) {
                    thirdMax  = secondMax;
                    secondMax = n;
                }
            } else if (n >= thirdMax) {
                if (n == Integer.MIN_VALUE)
                    return n;
                thirdMax = n;
                thirdSet = true;
            }
            System.out.println(firstMax + " " + secondMax + " " + thirdMax + " " + thirdSet);
        }
        return thirdSet == true ? thirdMax : firstMax;
    }

    /**
     * help from Nick's solution
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        Integer firstMax  = null;
        Integer secondMax = null;
        Integer thirdMax  = null;

        for (Integer n : nums) {
            if (n.equals(firstMax) || n.equals(secondMax) || n.equals(thirdMax))
                continue;

            if (firstMax == null || n > firstMax) {
                thirdMax  = secondMax;
                secondMax = firstMax;
                firstMax  = n;
            } else if (secondMax == null || n > secondMax) {
                thirdMax  = secondMax;
                secondMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }
        if (thirdMax == null)
            return firstMax;

        return thirdMax;
    }
}

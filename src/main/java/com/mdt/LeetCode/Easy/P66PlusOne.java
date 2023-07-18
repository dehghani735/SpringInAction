package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * date: 7/04/22
 */
public class P66PlusOne {

    /**
     * my solution
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        var length = digits.length;
        for (var i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        var newNumber = new int[length + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}

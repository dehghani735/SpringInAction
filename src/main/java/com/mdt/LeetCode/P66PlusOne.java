package com.mdt.LeetCode;

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
        var length       = digits.length;
        var hasRemainder = true;
        for (var i = length - 1; i >= 0; i--) {
            var result = digits[i] + (hasRemainder ? 1 : 0);
            if (result == 10) {
                hasRemainder = true;
                digits[i]    = 0;
                var dest = new int[digits.length + 1];
                if (i == 0) {
                    System.arraycopy(digits, 0, dest, 1, digits.length);
                    dest[0] = 1;
                    return dest;
                }
            } else {
                digits[i] = result;
                break;
            }
        }
        return digits;
    }
}

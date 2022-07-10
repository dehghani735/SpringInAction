package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * date: 7/05/22
 */
public class P67AddBinary {

    /**
     * my solution, it's so complex and uses redundant applications of everything!
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        var aLength   = a.length();
        var bLength   = b.length();
        var minLength = Math.min(aLength, bLength);
        var counter   = 0;
        var remainder = 0;
        var maxlength = Math.max(aLength, bLength);
        var result    = new StringBuilder();
        var stack     = new Stack<Integer>();
        while (counter != minLength) {
            var sum = Character.getNumericValue(a.charAt(aLength - counter - 1)) + Character.getNumericValue(b.charAt(bLength - counter - 1)) + remainder;
            if (sum > 1) {
                remainder = 1;
                stack.push(sum % 2);
            } else {
                remainder = 0;
                stack.push(sum);
            }
            counter++;
        }
        var maxLengthString = maxlength == bLength ? b : a;
        while (counter != maxlength) {
            var sum = Character.getNumericValue(maxLengthString.charAt(maxlength - counter - 1)) + remainder;
            if (sum > 1) {
                remainder = 1;
                stack.push(sum % 2);
            } else {
                remainder = 0;
                stack.push(sum);
            }
            counter++;
        }
        while (!stack.isEmpty())
            result.append(stack.pop());

        if (remainder == 1)
            return "1" + result;
        else
            return result.toString();
    }

    /**
     * Nick's solution. very nice
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        var sb    = new StringBuilder();
        var i     = a.length() - 1;
        var j     = b.length() - 1;
        var carry = 0;

        while (i >= 0 || j >= 0) {
            var sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}

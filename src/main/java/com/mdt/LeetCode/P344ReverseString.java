package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * date: 6/10/22
 */
public class P344ReverseString {

    /**
     * my solution
     * @param s
     */
    public void reverseString(char[] s) {
        char temp;
        var  size = s.length;
        for (var i = 0; i < size / 2; i++) {
            temp            = s[size - i - 1];
            s[size - i - 1] = s[i];
            s[i]            = temp;
        }
    }
}

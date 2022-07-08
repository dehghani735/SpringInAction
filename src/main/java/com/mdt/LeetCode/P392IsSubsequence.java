package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * date: 7/08/22
 */
public class P392IsSubsequence {

    /**
     * my solution
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        var sPointer = 0;
        var tPointer = 0;
        while (sPointer < s.length()) {
            while (tPointer < t.length() && s.charAt(sPointer) != t.charAt(tPointer)) {
                tPointer++;
            }
            if (tPointer == t.length() || s.charAt(sPointer) != t.charAt(tPointer))
                return false;

            sPointer++;
            tPointer++;
        }
        return true;
    }
}

package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 * <p>
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * <p>
 * date: 6/23/22
 */
public class P859BuddyStrings {

    /**
     * leetcode's solution
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            var counts = new int[26];
            for (var c : s.toCharArray())
                counts[c - 'a']++;
            for (var c : counts)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (var i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            return (second != -1 && s.charAt(first) == goal.charAt(second)
                    && s.charAt(second) == goal.charAt(first));
        }
    }
}

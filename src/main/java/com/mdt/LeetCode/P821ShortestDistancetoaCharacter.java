package com.mdt.LeetCode;

import java.util.ArrayList;

/**
 * Easy
 * <p>
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * <p>
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 * <p>
 * date: 6/23/22
 */
public class P821ShortestDistancetoaCharacter {

    /**
     * my solution
     *
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        var chars          = s.toCharArray();
        var charOccurances = new ArrayList<Integer>();

        for (var i = 0; i < chars.length; i++)
            if (chars[i] == c)
                charOccurances.add(i);

        var j   = 0;
        var ans = new int[chars.length];
        for (var i = 0; i < chars.length; i++) {
            if (j != charOccurances.size() && i > charOccurances.get(j))
                j++;

            ans[i] = Math.min(j == charOccurances.size() ? Integer.MAX_VALUE : Math.abs(i - charOccurances.get(j)),
                    j - 1 < 0 ? Integer.MAX_VALUE : Math.abs(i - charOccurances.get(j - 1)));
        }

        return ans;
    }

    /**
     * leetcode solution
     * idea: left to right sweep, right to left sweep
     *
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar2(String S, char C) {
        int   N    = S.length();
        int[] ans  = new int[N];
        int   prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}

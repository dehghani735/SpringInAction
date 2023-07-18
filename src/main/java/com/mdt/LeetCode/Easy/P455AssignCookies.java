package com.mdt.LeetCode.Easy;

import java.util.Arrays;

/**
 * Easy
 * <p>
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * <p>
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * <p>
 * date: 7/03/22
 */
public class P455AssignCookies {

    /**
     * Nick's solution
     * O(n log n)
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        var aPointer = 0;
        var bPointer = 0;

        while (aPointer < g.length && bPointer < s.length) {
            if (s[bPointer] >= g[aPointer]) {
                aPointer++;
                bPointer++;
            } else
                bPointer++;
        }
        return aPointer;
    }
}

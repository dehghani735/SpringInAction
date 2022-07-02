package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * date: 7/01/22
 */
public class P14LongestCommonPrefix {

    /**
     * my solution
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        var sb = new StringBuilder();
        int i  = 0, j = 0;
        while (i < strs[0].length() && j < strs[1].length() && strs[0].charAt(i) == strs[1].charAt(j)) {
            sb.append(strs[0].charAt(i));
            i++;
            j++;
        }

        for (var k = 2; k < strs.length; k++) {
            var t = 0;
            while (t < strs[k].length() && t < sb.length() && strs[k].charAt(t) == sb.charAt(t)) {
                t++;
            }
            if (t >= sb.length())
                continue;
            else
                sb.delete(t, sb.length());
        }
        return sb.toString();
    }

    /**
     * Nick's solution.
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        var prefix = strs[0];
        for (var i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}

package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * You are given a string s of lowercase English letters and an array widths denoting how many pixels wide each lowercase English letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.
 * <p>
 * You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at the beginning of s, write as many letters on the first line such that the total width does not exceed 100 pixels. Then, from where you stopped in s, continue writing as many letters as you can on the second line. Continue this process until you have written all of s.
 * <p>
 * Return an array result of length 2 where:
 * <p>
 * result[0] is the total number of lines.
 * result[1] is the width of the last line in pixels.
 * <p>
 * date: 6/30/22
 */
public class P806NumberofLinesToWriteString {

    /**
     * my solution
     *
     * @param widths
     * @param s
     * @return
     */
    public int[] numberOfLines(int[] widths, String s) {
        var counter       = 1;
        var threshold     = 100;
        var lastThreshold = 0;
        var chars         = s.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var currentCharWidth = widths[chars[i] - 'a'];
            lastThreshold += currentCharWidth;
            if (lastThreshold > threshold) {
                counter++;
                lastThreshold = 0;
                i--;
            }
        }

        return new int[]{counter, lastThreshold};
    }
}

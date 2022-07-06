package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given a string s, return the number of segments in the string.
 * <p>
 * A segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * date: 7/05/22
 */
public class P434NumberofSegmentsInAString {

    /**
     * my solution:
     * space complexity is O(n) because split (in both languages) returns an array/list of O(n) length, so the algorithm uses linear additional space.
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        s = s.trim().replaceAll(" +", " ");
        if (s.isEmpty()) return 0;
        return s.split(" ").length;
    }

    /**
     * Nick's solution:
     * space complexity is O(1)
     *
     * @param s
     * @return
     */
    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

    public static void main(String[] args) {
        var problem = new P434NumberofSegmentsInAString();
        System.out.println(problem.countSegments("                "));
    }
}

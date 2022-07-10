package com.mdt.LeetCode.Easy;

import java.util.ArrayDeque;

/**
 * Easy
 * <p>
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * <p>
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * <p>
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * <p>
 * date: 6/19/22
 */
public class P796RotateString {

    /**
     * my complex solution
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        var queue = new ArrayDeque<Character>();

        for (var c : s.toCharArray()) {
            queue.addLast(c);
        }

        for (var i = 0; i < queue.size(); i++) {
            queue.addLast(queue.removeFirst());

            if (goal.equals(getString(queue)))
                return true;
        }
        return false;
    }


    /**
     * Simple Check -> this solution has O(N^2) time complexity.
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    // TODO other approaches that has O(N) like rolling hash and KMP (Knuth-Morris-Pratt)

    private String getString(ArrayDeque<Character> queue) {
        var sb = new StringBuilder();
        for (var c : queue.toArray())
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        var problem = new P796RotateString();
        var b       = problem.rotateString("abcde", "cdeab");
    }
}

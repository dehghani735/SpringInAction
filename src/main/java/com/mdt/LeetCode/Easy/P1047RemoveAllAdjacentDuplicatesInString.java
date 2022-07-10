package com.mdt.LeetCode.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Easy
 * <p>
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * <p>
 * date: 6/18/22
 */
public class P1047RemoveAllAdjacentDuplicatesInString {

    /**
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {

        Deque<Character> stack = new ArrayDeque<Character>();
        for (var c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == c)
                stack.poll();
            else
                stack.push(c);
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pollLast());

        return sb.toString();
    }
}

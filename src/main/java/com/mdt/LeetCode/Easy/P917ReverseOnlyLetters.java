package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Given a string s, reverse the string according to the following rules:
 * <p>
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * <p>
 * Return s after reversing it.
 * <p>
 * date: 6/14/22
 */
public class P917ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        var stack = new Stack<Character>();

        for (var c : s.toCharArray())
            if (Character.isLetter(c))
                stack.push(c);

        var sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(stack.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }
}

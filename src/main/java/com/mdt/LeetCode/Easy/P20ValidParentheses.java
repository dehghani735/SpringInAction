package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * date: 7/02/22
 */
public class P20ValidParentheses {

    /**
     * my solution
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (var c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (top == '(' && c != ')') return false;
                else if (top == '[' && c != ']') return false;
                else if (top == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }
}

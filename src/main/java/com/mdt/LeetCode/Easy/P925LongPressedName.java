package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * <p>
 * You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * <p>
 * date: 6/23/22
 */
public class P925LongPressedName {

    /**
     * my shit solution!
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;

        var stack = new Stack<Character>();
        var j     = 0;
        for (var i = 0; i < typed.length(); i++) {
            stack.push(typed.charAt(i));

            while (i != typed.length() - 1 && typed.charAt(i) == typed.charAt(i + 1)) {
                stack.push(typed.charAt(++i));
            }

            if (j == name.length() || stack.isEmpty() || stack.peek() != name.charAt(j))
                return false;

            while (!stack.isEmpty() && stack.peek() == name.charAt(j)) {
                stack.pop();
                if (j != name.length() - 1 && name.charAt(j) == name.charAt(j + 1)) {
                    j++;
                    if (stack.isEmpty())
                        return false;
                }
            }
            j++;
        }
        if (j != name.length()) return false;

        return true;
    }

    /**
     * nick's solution, very straightforward
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName2(String name, String typed) {
        if (name.length() > typed.length()) return false;

        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return i == name.length();
    }
}

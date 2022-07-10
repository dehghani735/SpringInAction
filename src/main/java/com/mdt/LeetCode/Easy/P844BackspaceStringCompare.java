package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * date: 6/10/22
 */
public class P844BackspaceStringCompare {

    /**
     * O(n) space
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        return buildStr(s).equals(buildStr(t));
    }

    public String buildStr(String s) {
        var ans = new Stack<Character>();
        for (var c : s.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.isEmpty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    /**
     * O(1) space
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare2(String s, String t) {
        var sPointer = s.length() - 1;
        var tPointer = t.length() - 1;
        var sSkip    = 0;
        var tSkip    = 0;

        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    sSkip++;
                    sPointer--;
                } else if (sSkip > 0) {
                    sSkip--;
                    sPointer--;
                } else break;
            }
            while (tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    tSkip++;
                    tPointer--;
                } else if (tSkip > 0) {
                    tSkip--;
                    tPointer--;
                } else break;
            }
            if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer))
                return false;
            // length check
            if ((sPointer >= 0) != (tPointer >= 0))
                return false;
            sPointer--;
            tPointer--;
        }
        return true;
    }
}

package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * date: 6/9/22
 */
public class P709ToLowerCase {
    public String toLowerCase(String s) {
        // return s.toLowerCase();
        String result = "";
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                result = result + (char) (c + 32);
            else
                result = result + c;
        }
        return result;
    }
}

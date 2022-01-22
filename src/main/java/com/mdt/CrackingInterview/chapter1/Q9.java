package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of" erbottlewat").
 * <p>
 * date: 1/13/22
 */
public class Q9 {
    private static final Logger log = getLogger(Q9.class);

    public static void main(String[] args) {
        var s1 = "waterbottle";
        var s2 = "erbottlewat";

        var q9        = new Q9();
        var isRotated = q9.isRotated(s1, s2);
    }

    public boolean isRotated(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            var s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    // TODO implement
    private boolean isSubstring(String str1, String str2) {

        return false;
    }
}

package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 *
 * <p>
 * date: 6/20/22
 */
public class P1119RemoveVowelsFromString {

    public String removeVowels(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}

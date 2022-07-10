package com.mdt.LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * date: 7/04/22
 */
public class P242ValidAnagram {

    /**
     * my solution with some modifications from discussion of leetcode
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else if (s.length() != t.length()) return false;

        var hashMap = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (var c : t.toCharArray()) {
            var counter = hashMap.getOrDefault(c, 0);
            if (counter == 0) return false;
            hashMap.put(c, --counter);
        }
        return true;
    }

    /**
     * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
     * leetcode discussion solution
     * <p>
     * In Java, a Unicode could be represented by a single char(BMP, Basic Multilingual Plane) or two chars (high surrogate). Bascially, we can use
     * <p>
     * String.codePointAt(int index) method to get the integer representation of a Unicode (as the key in the hash table)
     * and use Character.charCount(int code) to count how many the characters are used there (to correctly increase our index)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else if (s.length() != t.length()) return false;

        Map<Integer, Integer> dict  = new HashMap<>();
        int                   index = 0;
        while (index < s.length()) {
            int charCode = s.codePointAt(index); // Get the integer representation of Unicode
            dict.put(charCode, dict.getOrDefault(charCode, 0) + 1);
            index += Character.charCount(charCode); // The Unicode could be represented by either one char or two chars
        }

        index = 0;
        while (index < t.length()) {
            int charCode = t.codePointAt(index);
            int count    = dict.getOrDefault(charCode, 0);

            if (count == 0) return false;
            else dict.put(charCode, count - 1);

            index += Character.charCount(charCode);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println((int) 'A' + " " + (int) 'a');
        var s = "AaBbstring";
        System.out.println(s.codePointAt(0) + " " + s.codePointAt(1));
    }
}

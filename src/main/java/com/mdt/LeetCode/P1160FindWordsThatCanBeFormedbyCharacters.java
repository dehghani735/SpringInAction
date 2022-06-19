package com.mdt.LeetCode;

import java.util.Arrays;

/**
 * Easy
 * <p>
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * date: 6/18/22
 */
public class P1160FindWordsThatCanBeFormedbyCharacters {

    public int countCharacters(String[] words, String chars) {
        var countChars = new int[26];
        for (var c : chars.toCharArray())
            countChars[c - 'a']++;

        var counter = 0;
        for (var s : words) {
            var tempChars = Arrays.copyOf(countChars, countChars.length);

            var temp = 0;
            for (var c : s.toCharArray()) {
                if (tempChars[c - 'a'] > 0) {
                    tempChars[c - 'a']--;
                    temp++;
                }
            }
            if (temp == s.length())
                counter += temp;
        }

        return counter;
    }
}

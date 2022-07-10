package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Easy
 * <p>
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 * <p>
 * date: 6/17/22
 */
public class P1002FindCommonCharacters {

    /**
     * TODO: very interesting solution, solve it again
     * @param words
     * @return
     */
    public List<String> commonChars(String[] words) {
        var minFrequencies = new int[26];
        Arrays.fill(minFrequencies, Integer.MAX_VALUE);

        for (var w : words) {
            var charFrequencies = new int[26];
            for (var c : w.toCharArray())
                charFrequencies[c - 'a']++;
            for (var i = 0; i < 26; i++)
                 minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
        }

        var res = new ArrayList<String>();
        for (var i = 0; i < 26; i++) {
            while (minFrequencies[i] > 0) {
                res.add("" + (char) (i + 'a'));
                minFrequencies[i]--;
            }
        }

        return res;
    }
}

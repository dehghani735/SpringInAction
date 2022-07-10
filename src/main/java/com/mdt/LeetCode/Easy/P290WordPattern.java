package com.mdt.LeetCode.Easy;

import java.util.HashMap;

/**
 * Easy
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * <p>
 * date: 7/03/22
 */
public class P290WordPattern {

    /**
     * my solution
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        var hashMap = new HashMap<Character, String>();
        var words   = s.split(" ");
        var p       = pattern.toCharArray();
        if (words.length != p.length) return false;

        for (var i = 0; i < p.length; i++) {
            if (hashMap.containsKey(p[i])) {
                if (!hashMap.get(p[i]).equals(words[i])) return false;
            } else {
                if (hashMap.containsValue(words[i]))
                    return false;
                hashMap.put(p[i], words[i]);
            }
        }
        return true;
    }
}

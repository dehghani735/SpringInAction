package com.mdt.LeetCode;

import java.util.HashMap;

/**
 * Easy
 * <p>
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * date: 6/27/22
 */
public class P953VerifyinganAlienDictionary {

    /**
     * my solution
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        var orderMap = new HashMap<Character, Integer>();

        // if (words.length <= 1) return true;

        var orderChars = order.toCharArray();
        for (var i = 0; i < order.length(); i++)
             orderMap.put(orderChars[i], i);


        for (var i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], orderMap))
                return false;
        }
        return true;
    }

    boolean compare(String a, String b, HashMap<Character, Integer> orderMap) {
        for (var i = 0; i < a.length() && i < b.length(); i++) {
            if (orderMap.get(a.charAt(i)) < orderMap.get(b.charAt(i)))
                return true;
            else if (orderMap.get(a.charAt(i)) > orderMap.get(b.charAt(i)))
                return false;
        }
        if (a.length() > b.length())
            return false;

        return true;
    }
}

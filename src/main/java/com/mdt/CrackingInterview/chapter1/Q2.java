package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * <p>
 * Questions:
 * character set? (VERY IMPORTANT)
 * case sensitive?
 * does white spaces matter?
 * date: 1/7/22
 */
public class Q2 {
    private static final Logger log = getLogger(Q2.class);

    public static void main(String[] args) {
        var q2      = new Q2();
        var result  = q2.permutation("ali", "lia");
        var result2 = q2.permutation("typo", "type");
        log.info(String.valueOf(result));
        log.info(String.valueOf(result2));

        result  = q2.optimizedPermutation("ali", "lia");
        result2 = q2.optimizedPermutation("typo", "type");
        log.info(String.valueOf(result));
        log.info(String.valueOf(result2));
    }

    /**
     * idea: if str1 is permutation of str2, the sorted of the both should be equal.
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean permutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        return sort(str1).equals(sort(str2));  // O(n log n)
    }

    /**
     * Note: Each line is important
     */
    String sort(String str) {
        var chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    /**
     * if str1 is a permutation of str2, both of them has the same number of characters for each character.
     *
     * @param str1
     * @param str2
     * @return
     */
    boolean optimizedPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        var counts = new int[128]; // assumption ASCII
        for (var c : str1.toCharArray())
            counts[c]++;

        for (var c : str2.toCharArray()) {
            counts[c]--;
            if (counts[c] < 0)
                return false;
        }

        return true;
    }
}

package com.mdt.LeetCode;

import java.util.HashSet;

/**
 * Easy
 *
 *
 * date: 6/15/22
 */
public class P804UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        var set = new HashSet<String>();
        var dic = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (var s : words) {
            var sb = new StringBuilder();
            for (var c : s.toCharArray())
                sb.append(dic[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {

    }
}

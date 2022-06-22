package com.mdt.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Easy
 * <p>
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 * <p>
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 * <p>
 * date: 6/21/22
 */
public class P819MostCommonWord {

    /**
     * my solution
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?',;.]", " ").replaceAll("  ", " ").toLowerCase();

        var dic   = new HashMap<String, Integer>();
        var words = paragraph.split(" ");
        for (var word : words) {
            if (!Arrays.stream(banned).anyMatch(it -> it.equals(word))) {
                if (dic.containsKey(word)) {
                    var x = dic.get(word);
                    dic.put(word, ++x);
                } else
                    dic.put(word, 1);
            }
        }

        var max      = Integer.MIN_VALUE;
        var maxIndex = "";
        for (var x : dic.keySet()) {
            if (dic.get(x) > max) {
                max      = dic.get(x);
                maxIndex = x;
            }
        }
        return maxIndex;
    }

    /**
     * nick's solution
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord2(String paragraph, String[] banned) {

        var dic   = new HashMap<String, Integer>();
        var words = paragraph.toLowerCase().split("\\W+"); // nice
        // banned can be chaned to hashSet
        for (var word : words) {
            if (!Arrays.stream(banned).anyMatch(it -> it.equals(word))) {
                dic.put(word, dic.getOrDefault(word, 0) + 1);
            }
        }

        var max      = Integer.MIN_VALUE;
        var maxIndex = "";
        for (var x : dic.keySet()) {
            if (dic.get(x) > max) {
                max      = dic.get(x);
                maxIndex = x;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        var problem = new P819MostCommonWord();
        System.out.println(
                problem.mostCommonWord(
                        "Bob. hIt, baLl",
                        new String[]{"bob", "hit"}));
    }
}

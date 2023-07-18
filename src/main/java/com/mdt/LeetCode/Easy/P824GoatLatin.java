package com.mdt.LeetCode.Easy;

import java.util.HashSet;

/**
 * Easy
 * <p>
 * <p>
 * <p>
 * date: 6/23/22
 */
public class P824GoatLatin {

    /**
     * my solution, somehow complex
     *
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        // split to words
        var words = sentence.split(" ");

        var result  = new StringBuilder();
        var counter = 1;
        // decide which type of word is this
        for (var word : words) {
            // change it based on the rules
            if (isVowel(word)) {
                result.append(word);
                result.append("ma");
            } else if (!isVowel(word)) {
                result.append(word.substring(1));
                result.append(word.charAt(0));
                result.append("ma");
            }

            for (var i = 0; i < counter; i++)
                 result.append("a");
            result.append(" ");
            counter++;
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private boolean isVowel(String word) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        return new String(vowels).indexOf(word.charAt(0)) != -1;
    }

    public String toGoatLatin2(String sentence) {

        var vowels = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray())
            vowels.add(c);

        String result = "";
        var    index  = 1;
        for (var word : sentence.split("\\s")) {
            if (index > 1)
                result += " ";

            char firstLetter = word.charAt(0);
            if (vowels.contains(firstLetter))
                result += word + "ma";
            else result += word.substring(1) + firstLetter + "ma";

            for (var j = 0; j < index; j++)
                 result += "a";

            index += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        var s = "4";
        System.out.println(s.substring(1));
    }
}

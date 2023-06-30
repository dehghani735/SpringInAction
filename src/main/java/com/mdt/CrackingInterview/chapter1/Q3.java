package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 * <p>
 * date: 1/7/22
 */
public class Q3 {

    private static final Logger log = getLogger(Q3.class);

    public static void main(String[] args) {
        var q3     = new Q3();
        var result = q3.urlify("Mr John Smith    ", 13);
        log.info(result);
    }

    /**
     * One common approach in string manipulation problems is to edit string from the end.
     * use a two-scan approach: first count the spaces, the edit string
     *
     * @param str
     * @param trueLength
     * @return
     */
    public String urlify(String str, int trueLength) {
        var chars      = str.toCharArray();
        var length     = chars.length;
        var difference = length - trueLength;
        int spaceCount = 0, index = 0;

        for (int i = 0; i < trueLength; i++)
            if (chars[i] == ' ')
                spaceCount++;
        index = trueLength + 2 * spaceCount;
        for (var i = trueLength - 1; i > 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= 3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }

        return String.valueOf(chars);
    }
}

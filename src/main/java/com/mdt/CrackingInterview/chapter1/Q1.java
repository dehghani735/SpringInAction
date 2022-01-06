package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 * <p>
 * date: 1/6/22
 */
public class Q1 {

    private static final Logger log = getLogger(Intro.class);

    /**
     * Make assumption: Is the string ascii string or unicode string?
     * we assume it's ascii
     * ascii; American Standard code for information interchange: defines 128 characters which map to the numbers 0-127
     * unicode; Universal character set: defines 2^21 characters
     * unicode is a superset of ASCII and the numbers 0-127 have the same meaning in ASCII as they have in Unicode.
     * Because unicode characters don't generally fit into one 8-bit Byte, there are numerous ways of storing unicode characters in
     * Byte sequences such as UTF-32 and UTF-8
     * <p>
     * 2^7 = 0 - 127 -> ASCII
     * for other languages => 2 * 2^7 = 256 = 1B -> Extended ASCII. other examples: ISO 8859, ISO Latin-1
     * ASCII Extended solves Latin-based languages => need an entirely new character set.
     * Unicode doesn't contain every character from every language, but it contains a lot of characters.
     * You cannot save text to your hard drive as "Unicode". Unicode is an abstract representation of the text.
     * You need to "encode" this abstract representation. That's where an "encoding" comes into play.
     * Encodings:
     * UTF8 and 16 => variable length encodings
     * in UTF8, a character may occupy a minimum of 8 bits.
     * in UTF16, a character May starts with 16 bits.
     * UTF-32 is a fixed length encoding of 32 bits.
     * <p>
     * UTF-8 uses the ASCII set for the first 128 characters => It means ASCII text is also valid in UTF-8
     * Therefore, ASCII uses 7 bits to represent a character.
     * Unicode uses 8, 16 or 32 bits depending on the encoding type.
     *
     * @param args
     */
    public static void main(String[] args) {
        var q1 = new Q1();
        System.out.println(q1.isASCIIUnique("red"));
        System.out.println(q1.isASCIIUnique("bee"));

        int a = 'a';
        System.out.println(a);

        System.out.println(q1.isAtoZUnique("blue"));
        System.out.println(q1.isAtoZUnique("green"));
    }

    /**
     * Assumption: string is ASCII
     *
     * @param str
     * @return Whether all characters are unique.
     */
    boolean isASCIIUnique(String str) {
        if (str.length() > 128) return false;

        var charSet = new boolean[128]; // Note: It's false by default
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) return false;

            charSet[val] = true;
        }

        return true;
    }

    /**
     * Assumption: string is a-z
     * <p>
     * bitwise operators:
     * shift:
     * value <operator> <number_of_times>
     * - signed left shift <<
     * - signed right shift >>
     * -- 1 for negative number
     * -- 0 for positive number
     * - unsigned right shift >>>: the empty spaces in the left are filled with 0 irrespective of whether the number is positive or negative
     *
     * @param str
     * @return Whether all characters are unique.
     */
    boolean isAtoZUnique(String str) {
        int checker = 0; // bit vector
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= 1 << val;
        }

        return true;
    }

// Solution without using space:
// compare character by character => takes O(n^2) time
//or sort the string inline O(n log n)
}

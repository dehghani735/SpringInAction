package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.6 String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class Q6 {
    private static final Logger log = getLogger(Q6.class);

    public static void main(String[] args) {
        var q6     = new Q6();
        var result = q6.compressed("aabcccccaaa");
        log.info(result);
    }

    /**
     * TODO review next time, it could be better and less error prone.
     *
     * @param str
     * @return
     */
    public String compressed(String str) {
        var oldLength = str.length();
        var sb        = new StringBuilder(); // good point
        var count     = 1;
        var index     = 1;

        for (var i = 0; i < str.length(); i++, index++) {
            if (index < str.length() && str.charAt(i) == str.charAt(index)) {
                count++;
            } else {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 1;
            }
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }

    /**
     * using pre-processing to compute the final length of new string
     * TODO: do next time
     *
     * @param str
     * @return
     */
    public String compressed2(String str) {
        var finalLength = computeCompression(str);

        return "";
    }

    /**
     * ab
     *
     * @param str
     * @return
     */
    private int computeCompression(String str) {
        var count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) != str.charAt(i + 1))
                count++;
        }

        return 0;
    }
}

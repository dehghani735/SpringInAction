package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * <p>
 * date: 7/09/22
 */
public class P459RepeatedSubstringPattern {

    /**
     * Nick's solution, interesting
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        var len = s.length();
        for (var i = len / 2; i > 0; i--) {
            if (len % i == 0) {
                var numRepeats = len / i;
                var substring  = s.substring(0, i);

                if (substring.repeat(numRepeats).equals(s))
                    return true;
            }
        }
        return false;
    }
}

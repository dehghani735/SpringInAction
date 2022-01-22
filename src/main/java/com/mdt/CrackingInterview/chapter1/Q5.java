package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.5 One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 * <p>
 * date: 1/9/22
 */
public class Q5 {
    private static final Logger log = getLogger(Q5.class);

    public static void main(String[] args) {
        var q5 = new Q5();
        log.info(String.valueOf(q5.oneEditAway1("pale", "bale")));
        log.info(String.valueOf(q5.oneEditAway1("pale", "ple")));
        log.info(String.valueOf(q5.oneEditAway1("pale", "pales")));
        log.info(String.valueOf(q5.oneEditAway1("pale", "bae")));
    }

     public boolean oneEditAway1(String str1, String str2) {
        if (str1.length() == str2.length())
            return checkOneReplace(str1, str2);
        else if (str1.length() + 1 == str2.length())
            return checkOneInsert(str1, str2);
        else if (str1.length() - 1 == str2.length())
            return checkOneInsert(str2, str1);
        else
            return false;
    }

    /**
     * @param str1 is smaller than str2
     * @param str2
     * @return
     */
    private boolean checkOneInsert(String str1, String str2) {
        int index1             = 0, index2 = 0;
        var foundOneDifference = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (foundOneDifference)
                    return false;
                index2++;
                foundOneDifference = true;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private boolean checkOneReplace(String str1, String str2) {
        var foundOneDifference = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (foundOneDifference)
                    return false;
                foundOneDifference = true;
            }
        }

        return true;
    }

    /**
     * Refactoring all above.
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean oneEditAway2(String str1, String str2) {
        return false; // TODO make it compact
    }
}

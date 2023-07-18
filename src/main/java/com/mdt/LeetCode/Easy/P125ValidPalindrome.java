package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Easy
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * date: 6/10/22
 */
public class P125ValidPalindrome {

    /**
     * my solution
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        var beginNumeric = (int) '0';
        var endNumeric   = (int) '9';
        var startLetter  = (int) 'a';
        var endLetter    = (int) 'z';
        var x            = new ArrayList<Character>();
        for (var c : s.toCharArray()) {
            var numeric = (int) c;
            if ((numeric >= beginNumeric && numeric <= endNumeric) || (numeric >= startLetter && numeric <= endLetter))
                x.add(c);
        }
        var reverseX = (ArrayList<Character>) x.clone();
        Collections.reverse(reverseX);

        for (var i = 0; i < x.size() / 2; i++) {
            if (x.get(i) != reverseX.get(i))
                return false;
        }
        return true;
    }

    /**
     * nick's approach
     *
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        var fixed_string = "";

        for (var c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) // Note
                fixed_string += c;
        }
        fixed_string = fixed_string.toLowerCase(); // Note: this method returns output

        var a_pointer = 0;
        var b_pointer = fixed_string.length() - 1;
        while (a_pointer <= b_pointer) {
            if (fixed_string.charAt(a_pointer) != fixed_string.charAt(b_pointer))
                return false;

            a_pointer++;
            b_pointer--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println((int) '1');


    }
}
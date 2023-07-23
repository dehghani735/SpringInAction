package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * date: 6/9/22
 * <p>
 * Very important note: If we reverse the whole number, we may get max int exception.
 */
public class P9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;

        var reversed_int = 0;
        while (x > reversed_int) {
            var remainder = x % 10;
            x /= 10;

            reversed_int = (reversed_int * 10) + remainder;
        }

        if (x == reversed_int || x == reversed_int / 10)
            return true;
        else return false;
    }

//    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//    }

    public static void main(String[] args) {
        String str = "abc def";
        String reversedString = reverseWords(str);
        System.out.println(reversedString);
    }

    public static String reverseWords(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = 0;
        while (end < charArray.length) {
            if (charArray[end] == ' ') {
                reverseWord(charArray, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        // Reverse the last word
        reverseWord(charArray, start, end - 1);

        return new String(charArray);
    }

    public static void reverseWord(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}

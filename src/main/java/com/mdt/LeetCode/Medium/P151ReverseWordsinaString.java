package com.mdt.LeetCode.Medium;

/**
 * Medium
 * 27 jul 2023
 */
public class P151ReverseWordsinaString {

    public static void main(String[] args) {

        var processor = new P151ReverseWordsinaString();
        var input = "  Hello    world!";
        var reversed = processor.reverseWords(input);
        System.out.println(reversed);
    }

    public String reverseWords(String s) {
        String result = new String();
        int i = 0;
        int n = s.length();

        while (i < n) {
            while (i < n && s.charAt(i) == ' ') i++;
            if (i >= n) break;
            int j = i + 1;
            while (j < n && s.charAt(j) != ' ') j++;
            String sub = s.substring(i, j);
            if (result.length() == 0) result = sub;
            else result = sub + " " + result;
            i = j + 1;
        }
        return result;
    }
}

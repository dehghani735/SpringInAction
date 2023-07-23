package com.mdt.LeetCode.Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P1TwoSum {

    public static String reversePartialString(String str, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder(str);

        while (startIndex < endIndex) {
            char temp = sb.charAt(startIndex);
            sb.setCharAt(startIndex, sb.charAt(endIndex));
            sb.setCharAt(endIndex, temp);
            startIndex++;
            endIndex--;
        }

        return sb.toString();
    }

//    public static void main(String[] args) {
//        String str = "Hello, World!";
//        int startIndex = 6;
//        int endIndex = 12;
//
//        String reversedString = reversePartialString(str, startIndex, endIndex);
//        System.out.println(reversedString);
//    }

    //        public static void main(String[] args) {
//            String str = "abc def";
//            String reversedString = reverseString(str);
//            System.out.println(reversedString);
//        }
//
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                wordBuilder.insert(0, c);
            } else {
                sb.append(wordBuilder).append(" ");
                wordBuilder.setLength(0);
            }
        }

        sb.append(wordBuilder);

        return sb.toString();
    }

    public static String reverseString2(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }

        return new String(charArray);
    }


//    public static void main(String[] args) {
//        String str = "abc def";
//        String reversedString = reverseString2(str);
//        System.out.println(reversedString);
//    }

    public static void main(String[] args) {
        String input = "abc def fgg";
        Stack<Character> stk = new Stack<>();
        List<String> parts = new LinkedList<>();

        for (var i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                extracted(stk, parts);
            } else {
                stk.push(input.charAt(i));
            }
        }
        if (!stk.isEmpty()) {
            extracted(stk, parts);
        }

        System.out.println(parts);
    }

    private static void extracted(Stack<Character> stk, List<String> parts) {
        StringBuilder sb = new StringBuilder(stk.size());
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        parts.add(sb.toString());
    }

//    public static void main(String[] args) {
//        String originalStr = "abc def ghi";
//
//        String words[] = originalStr.split("\\s");
//        String reversedString = "";
//
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            String reverseWord = "";
//            for (int j = word.length() - 1; j >= 0; j--) {
//                reverseWord = reverseWord + word.charAt(j);
//            }
//            reversedString = reversedString + reverseWord + " ";
//        }
//
//        System.out.print("Reversed string : " + reversedString);
//    }

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no match found");
    }
}

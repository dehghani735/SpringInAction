package com.mdt.HackerRank.DataStructure.C12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int NUMBER_LETTERS = 26; //

    public static void main(String[] args) throws IOException {
        var br     = new BufferedReader(new InputStreamReader(System.in));
        var first  = br.readLine();
        var second = br.readLine();
        System.out.println(numberNeeded(first, second));
    }

    private static int numberNeeded(String first, String second) {
        var charCounts1 = getCharCounts(first);
        var charCounts2 = getCharCounts(second);
        return getDelta(charCounts1, charCounts2);
    }

    private static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return -1; // todo: better error handling
        var delta = 0;
        for (int i = 0; i < array1.length; i++) {
            var difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

    private static int[] getCharCounts(String string) {
        var charCounts = new int[NUMBER_LETTERS]; // Note: if we have bigger variety of strings, we might use a hash map instead.
        for (int i = 0; i < string.length(); i++) {
            var c      = string.charAt(i);
            var offset = (int) 'a';
            var code   = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }
}

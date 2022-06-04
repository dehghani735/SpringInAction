package com.mdt.HackerRank.Algorithm.C15;

public class Solution {
    private static int lonelyInteger(int[] arr) {
        var result = 0;
        for (var x: arr){
             result ^= x;
        }
        return result;
    }

    public static void main(String[] args) {
        var x = Solution.lonelyInteger(new int[]{4, 5, 6, 5, 4, 6, 10, 12, 12});
        System.out.println(x);
    }
}

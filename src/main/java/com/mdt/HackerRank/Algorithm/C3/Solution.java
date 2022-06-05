package com.mdt.HackerRank.Algorithm.C3;

public class Solution {

    public static boolean binarySearchRecursive(int[] array, int x){
        return binarySearchRecursive(array, x, 0, array.length -1);
    }

    private static boolean binarySearchIterative(int[] array, int x) {
        var left = 0;
        var right = array.length - 1;
        while (left <= right) {
            var mid = (left + right) / 2; // note: left  + right can overflow in java integers; so we can change it to: left + ((right - left) / 2)
            if (x == array[mid])
                return true;
            else if (x < array[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    private static boolean binarySearchRecursive(int[] array, int x, int left, int right) { // right is inclusive
        if (right > left)
            return false;
        var mid = (left + right) /2; // note: left  + right can overflow in java integers; so we can change it to: left + ((right - left) / 2)
        if (x == array[mid])
            return true;
        else if (x < array[mid])
            return binarySearchRecursive(array, x, left, mid - 1);
        else
            return binarySearchRecursive(array, x, mid + 1, right);
    }

    public static void main(String[] args) {

    }
}

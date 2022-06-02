package com.mdt.HackerRank.Algorithm.C8;

public class Solution {

    public static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;
        var middle = (leftStart + rightEnd) / 2;
        mergesort(array, temp, leftStart, middle);
        mergesort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        var leftEnd    = (leftStart + rightEnd) / 2;
        var rightStart = leftEnd + 1;
        var size       = rightEnd - leftStart + 1;

        var left  = leftStart;
        var right = rightStart;
        var index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1); // either left or right pointer is at end, so only one of these lines will have an effect
        System.arraycopy(array, right, temp, index, rightEnd - right + 1); // either left or right pointer is at end, so only one of these lines will have an effect
        System.arraycopy(temp, leftStart, array, leftStart, size); // copying everything back
    }

    public static void main(String[] args) {
        var array = new int[]{5, 4, 3, 2, 1};
        Solution.mergesort(array);
        for (var x : array)
            System.out.print(x + ", ");
    }
}

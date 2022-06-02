package com.mdt.HackerRank.Algorithm.C7;

public class Solution {

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int left, int right) {
        if (left >= right)
            return;
        var pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        System.out.println("index is: " + index);
        quicksort(array, left, index - 1);
        System.out.println("test");
        quicksort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        System.out.println("start partitioning: " + left + ", " + right + ", " + pivot);
        while (left <= right) { // TODO it is infinite. if I remove = it goes stackover flow. what to do?
            while (array[left] < pivot)
                left++;
//            System.out.println("left: " + left);
            while (array[right] > pivot)
                right--;
//            System.out.println("right: " + right);
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        System.out.println("end of partitioning left: " + left);
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        var temp = array[left];
        array[left]  = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        var array = new int[]{5, 4, 3, 2, 1};
        Solution.quicksort(array);
        for (var x : array)
            System.out.print(x + ", ");
    }
}

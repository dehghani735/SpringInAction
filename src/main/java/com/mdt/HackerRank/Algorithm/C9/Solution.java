package com.mdt.HackerRank.Algorithm.C9;

import org.jooq.tools.StopWatch;

import java.util.Random;
import java.util.stream.IntStream;

public class Solution {

    public static void bubblesort(int[] array) {
        var isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    /**
     * on fist step, last element will be the max, so we can shrink the array size to minus one each time.
     */
    public static void bubblesortOptimized(int[] array) {
        var isSorted     = false;
        var lastUnsorted = array.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    public static void swap(int[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        var array = new Random().ints(100000, 0, 100000).toArray();
        System.out.println(array[0]);
        var stopWatch    = new StopWatch();
        Solution.bubblesort(array);
        stopWatch.splitDebug("array is sorted:");
        System.out.println(array[0]);
        array = new Random().ints(100000, 0, 100000).toArray();
        Solution.bubblesortOptimized(array);
        stopWatch.splitDebug("array is sorted:");
        System.out.println(array[0]);
    }
}

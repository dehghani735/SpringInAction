package com.mdt.LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Easy
 * <p>
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 * <p>
 * date: 7/07/22
 */
public class P1207UniqueNumberOfOccurrences {

    /**
     * my solution, working with set is ugly
     * <p>
     * O(n) both time and space complexity
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        var dict = new HashMap<Integer, Integer>();

        for (var a : arr) {
            dict.put(a, dict.getOrDefault(a, 0) + 1);
        }

        var set    = new HashSet<Integer>();
        var values = dict.values();
        for (var v : values) {
            if (!set.add(v))
                return false;
        }
        return true;
    }

    /**
     * Nick's solution, make use of set constructor
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences2(int[] arr) {
        var dict = new HashMap<Integer, Integer>();

        for (var a : arr)
            dict.put(a, dict.getOrDefault(a, 0) + 1);

        var set = new HashSet(dict.values());
        return dict.size() == set.size();
    }
}

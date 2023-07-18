package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Easy
 * <p>
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * <p>
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * <p>
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * <p>
 * date: 7/07/22
 */
public class P1200MinimumAbsoluteDifference {

    /**
     * my solution. there is also O(n) solution with counting sort which is noticed in google doc
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        var dict = new HashMap<Integer, ArrayList<Integer>>();
        var min  = Integer.MAX_VALUE;
        for (var i = 0; i < arr.length - 1; i++) {
            var diff = Math.abs(arr[i] - arr[i + 1]);
            min = Math.min(diff, min);
            var value = dict.getOrDefault(diff, new ArrayList<>());
            value.add(i);
            dict.put(diff, value);
        }
        var                 minDiffIndexes = dict.get(min);
        List<List<Integer>> result         = new ArrayList<>();
        for (var index : minDiffIndexes) {
            var x = List.of(arr[index], arr[index + 1]);
            result.add(x);
        }
        return result;
    }
}

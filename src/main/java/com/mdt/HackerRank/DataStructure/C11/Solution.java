package com.mdt.HackerRank.DataStructure.C11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static double[] getMedians(int[] array) {
        var lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        }); // TODO why this comparator needed? I think because it's a max heap
        var highers = new PriorityQueue<Integer>();
        var medians = new double[array.length];
        for (var i = 0; i < array.length; i++) {
            var number = array[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        var biggerHeap  = lowers.size() > highers.size() ? lowers : highers;
        var smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() != smallerHeap.size())
            return biggerHeap.peek();
        else
            return (double) (biggerHeap.peek() + smallerHeap.peek()) / 2; // tricky, integer division. // TODO (double) inside parenthesis or outside?
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        var biggerHeap  = lowers.size() > highers.size() ? lowers : highers;
        var smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() > 1)
            smallerHeap.add(biggerHeap.poll());
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }
}

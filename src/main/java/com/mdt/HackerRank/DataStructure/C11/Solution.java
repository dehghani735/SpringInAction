package com.mdt.HackerRank.DataStructure.C11;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Continuous median problem
 */
public class Solution {

    public static void main(String[] args) {
        var x = new int[] {4,5,2,1,4,3,7,5,9,10};
        var y = Solution.getMedians(x);
        Arrays.stream(y).forEach(System.out::println);
    }

    public static double[] getMedians(int[] array) {
        var lowers = new PriorityQueue<Integer>((o1, o2) -> -1 * o1.compareTo(o2)); // TODO why this comparator needed? I think because it's a max heap
        var highers = new PriorityQueue<Integer>();
        var medians = new double[array.length];
        for (var i = 0; i < array.length; i++) {
            var number = array[i];
            addNumber(number, lowers, highers);
            reBalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }

    private static void reBalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        var biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        var smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() > 1)
            smallerHeap.add(biggerHeap.poll());
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        var biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        var smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() != smallerHeap.size())
            return biggerHeap.peek();
        else
            return (double) (biggerHeap.peek() + smallerHeap.peek()) / 2; // tricky, integer division. // TODO (double) inside parenthesis or outside?
    }
}

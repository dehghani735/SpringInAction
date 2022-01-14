package com.mdt.CrackingInterview.intro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bottlenecks, Unnecessary work, Duplicated work
 * Given an array of distinct integer values, count the number of pairs of integers that have difference k.
 *
 * @author MDT
 * Date: 000417
 */
public class BUD {

    public static void main(String[] args) {
        var                      n       = 1000;
        var                      result  = 0;
        Map<Integer, List<Pair>> memoize = new HashMap<>();

        for (int c = 0; c < n; c++) {
            for (int d = 0; d < n; d++) {
                result = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                memoize.computeIfAbsent(result, k -> new ArrayList<>()).add(new Pair(c, d));
            }
        }

//        one way:
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                result = (int) (Math.pow(a, 3) + Math.pow(b, 3));
                var matches = memoize.get(result);
                int finalA  = a;
                int finalB  = b;
                System.out.println(finalA + ", " + finalB + ", " + matches);

            }
        }

//        optimize:
        for (var pairsList : memoize.values()) {
            for (var pair : pairsList)
                for (var pair2 : pairsList)
                    System.out.println(pair + ", " + pair2);
        }
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    static class Pair {
        private int a;
        private int b;
    }
}

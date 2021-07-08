package com.mdt.CrackingInterview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Optimize {

    public static void main(String[] args) {
        var n = 10000;
        var result = 0;
        Map<Integer, List<Pair>> memoize = new HashMap<>();

        for (int c = 0; c < n; c++) {
            for (int d = 0; d < n; d++) {
                result = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                memoize.computeIfAbsent(result, k -> new ArrayList<>()).add(new Pair(c, d));
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                result = (int) (Math.pow(a, 3) + Math.pow(b, 3));
                var matches = memoize.get(result);
                int finalA = a;
                int finalB = b;
                System.out.println(finalA + ", " + finalB + ", " + matches);

            }
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

package com.mdt.epi;

import java.util.Arrays;
import java.util.List;

public class P6_2_IncrementAnArbitrary {

    public static void main(String[] args) {
        P6_2_IncrementAnArbitrary problem = new P6_2_IncrementAnArbitrary();
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<Integer> result = problem.plusOne(input);
        System.out.println(result);
    }

    public List<Integer> plusOne(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }
        if (A.get(0) == 10) {
            A.set(0, 0);
            A.add(0, 1);
        }

        return A;
    }
}

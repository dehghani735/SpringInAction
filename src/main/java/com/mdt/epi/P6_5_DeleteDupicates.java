package com.mdt.epi;

import java.util.Arrays;
import java.util.List;

public class P6_5_DeleteDupicates {
    public static void main(String[] args) {
        P6_5_DeleteDupicates problem = new P6_5_DeleteDupicates();

        List<Integer> input = Arrays.asList(1, 2, 3);
        int result = problem.deleteDuplicates(input);

        System.out.println(result);
    }

    public int deleteDuplicates(List<Integer> A) {
        if (A.isEmpty())
            return 0;

        int writeIndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            if (!A.get(writeIndex - 1).equals(A.get(i))) {
                A.set(writeIndex++, A.get(i));
            }
        }
        return writeIndex;
    }
}

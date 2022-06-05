package com.mdt.HackerRank.Algorithm.C6;

/**
 * time and space complexity explained in google doc: https://docs.google.com/document/d/10YZZUK-5WfRPYpkszNVKrBxTX7xSOcbQNL6FwV2yarM/edit#bookmark=id.mgz21svp8ut1
 *
 * result for input 100 is negative. TODO how solve it?
 */
public class Solution {

    public static int countPathsR(int steps) {
        if (steps < 0)
            return 0;
        else if (steps == 0)
            return 1;
        return countPathsR(steps - 1) + countPathsR(steps - 2) + countPathsR(steps - 3);
    }

    public static long countPathsMemo(int steps) {
        if (steps < 0)
            return 0;
        return countPathsMemo(steps, new long[steps + 1]);
    }

    public static long countPathsMemo(int steps, long[] memo) {
        if (steps < 0)
            return 0;
        if (steps == 0)
            return 1;
        if (memo[steps] == 0)
            memo[steps] = countPathsMemo(steps - 1, memo)
                          + countPathsMemo(steps - 2, memo)
                          + countPathsMemo(steps - 3, memo);
        return memo[steps];
    }

    /**
     * iterative using dynamic programming
     */
    public static long countPathsDP(int steps) {
        if (steps < 0)
            return 0;
        else if (steps <= 1)
            return 1;
        var paths = new int[steps + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= steps; i++)
             paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
        return paths[steps];
    }

    public static long countPathsI(int steps) {
        if (steps < 0)
            return 0;
        else if (steps <= 1)
            return 1;
        int[] paths = {1, 1, 2};
        for (int i = 3; i <= steps; i++) {
            var count = paths[2] + paths[1] + paths[0];
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = count;
        }
        return paths[2];
    }

    public static void main(String[] args) {
//        System.out.println(Solution.countPaths(100));
        var memo = new long[101];
        System.out.println(Solution.countPathsMemo(100, memo));
        for (long l : memo) System.out.println(l);
    }
}

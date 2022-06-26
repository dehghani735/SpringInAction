package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * date: 6/26/22
 */
public class P746MinCostClimbingStairs {

    /**
     * nick's solution
     * <p>
     * if you allow to modify the array
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        for (var i = 2; i < cost.length; i++)
             cost[i] += Math.min(cost[i - 1], cost[i - 2]);

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    /**
     * nick's solution
     * <p>
     * another approach: dynamic programming (DP) TODO why?
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        var step1 = 0;
        var step2 = 0;

        for (var i = cost.length - 1; i >= 0; i--) {
            var currentStep = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = currentStep;
        }

        return Math.min(step1, step2);
    }
}

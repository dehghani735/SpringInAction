package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * date: 6/17/22
 */
public class P121BestTimetoBuyandSellStock {

    /**
     * I made it much complex;
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        var cumulative = new int[prices.length];

        for (var i = 0; i < prices.length - 1; i++) {
            cumulative[i + 1] = prices[i + 1] - prices[i] + Math.max(0, cumulative[i]);
        }

        var max = cumulative[0];
        for (var i = 0; i < cumulative.length; i++)
             max = Math.max(max, cumulative[i]);
        return max < 0 ? 0 : max;
    }

    /**
     * Nick's solution, optimized
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        var minValue  = Integer.MAX_VALUE;
        var maxProfit = 0;

        for (var i = 0; i < prices.length; i++) {
            if (prices[i] < minValue)
                minValue = prices[i];
            else if (prices[i] - minValue > maxProfit)
                maxProfit = prices[i] - minValue;
        }

        return maxProfit;
    }
}

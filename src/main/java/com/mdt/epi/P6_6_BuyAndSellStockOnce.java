package com.mdt.epi;

import java.util.Arrays;
import java.util.List;

public class P6_6_BuyAndSellStockOnce {

    public static void main(String[] args) {
        P6_6_BuyAndSellStockOnce problem = new P6_6_BuyAndSellStockOnce();

        List<Double> input = Arrays.asList(1.0, 2.0, 3.0, 2.0, 5.0);

        double result = problem.computeMaxProfit(input);
        System.out.println(result);
    }

    public double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}

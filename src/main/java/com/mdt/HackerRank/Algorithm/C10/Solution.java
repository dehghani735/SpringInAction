package com.mdt.HackerRank.Algorithm.C10;

import java.util.HashMap;

public class Solution {

    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<String, Long>());
    }

    /**
     * @param coins
     * @param money
     * @param index tells us which coin we are considering
     * @return
     */
    public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
        if (money == 0)
            return 1;
        if (index >= coins.length)
            return 0;
        var key = money + "-" + index; // "29" + "1"  || "2" + "91" => so - is necessary
        if (memo.containsKey(key))
            return memo.get(key);
        var  amountWithCoin = 0; // the amount of money we have used from this particular coin
        long ways           = 0;
        while (amountWithCoin <= money) {
            var remaining = money - amountWithCoin; // the amount of money remaining we need to make
            ways += makeChange(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index];
        }
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {

    }
}

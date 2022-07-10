package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * <p>
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * A self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
 * <p>
 * date: 6/16/22
 */
public class P728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        var ans = new ArrayList<Integer>();

        for (var i = left; i <= right; i++)
            if (selfDividing(i)) ans.add(i);
        return ans;
    }

    public boolean selfDividing(int n) {
        for (var c : String.valueOf(n).toCharArray())
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        return true;
    }
}

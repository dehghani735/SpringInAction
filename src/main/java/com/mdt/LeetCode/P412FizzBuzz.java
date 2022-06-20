package com.mdt.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * <p>
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * date: 6/20/22
 */
public class P412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        var result = new ArrayList<String>();

        for (var i = 1; i <= n; i++) {
            var s = "";
            if (i % 3 != 0 && i % 5 != 0)
                s = String.valueOf(i);
            if (i % 3 == 0)
                s += "Fizz";
            if (i % 5 == 0)
                s += "Buzz";
            result.add(s);
        }
        return result;
    }
}

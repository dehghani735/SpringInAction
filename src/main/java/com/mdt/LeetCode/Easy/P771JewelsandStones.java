package com.mdt.LeetCode.Easy;

import java.util.HashSet;

/**
 * Easy
 * <p>
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * date: 6/12/22
 */
public class P771JewelsandStones {

    /**
     * my complex solution, it's slow
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        var jewelsTypes = new HashSet<Character>();
        for (var j : jewels.toCharArray())
            jewelsTypes.add(j);

        var counter = 0;
        for (var s : stones.toCharArray()) {
            if (jewelsTypes.contains(s))
                counter++;
        }
        return counter;
    }

    /**
     * nick's solution: fast. Note: indexOf method
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones2(String jewels, String stones) {

        var counter = 0;
        for (var s : stones.toCharArray()) {
            if (jewels.indexOf(s) > -1)
                counter++;
        }
        return counter;
    }
}

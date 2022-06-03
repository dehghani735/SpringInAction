package com.mdt.HackerRank.Algorithm.C12;

import java.util.Arrays;
import java.util.Comparator;

public class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            // use the names
            return a.name.compareTo(b.name);
        }
        return a.score - b.score;
    }

    /**
     * TODO how to check this comparator?
     * @param args
     */
    public static void main(String[] args) {
        var p1  = new Player("Ali", 19);
        var p2  = new Player("Mohammad", 20);
        var arr = new Player[]{p1, p2};
        Arrays.sort(arr);

        for (var x: arr)
            System.out.println(x.name + " | " + x.score);
    }
}

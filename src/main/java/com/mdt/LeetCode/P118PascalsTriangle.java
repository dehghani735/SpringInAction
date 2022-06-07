package com.mdt.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * date: 6/7/22
 * <p>
 * TODO: it used a lot of memory. How to reduce it?
 */
public class P118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        var triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) return triangle;

        var firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            var prevRow = triangle.get(i - 1);
            var row     = new ArrayList<Integer>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        var q = new P118PascalsTriangle();
        System.out.println(q.generate(5)); // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}

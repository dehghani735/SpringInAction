package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given a 2D integer array matrix, return the transpose of matrix.
 * <p>
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 * <p>
 * date: 6/17/22
 */
public class P867TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        var r = matrix.length;
        var c = matrix[0].length;

        var newArr = new int[c][r];

        for (var i = 0; i < r; i++)
            for (var j = 0; j < c; j++)
                 newArr[j][i] = matrix[i][j];

        return newArr;
    }
}

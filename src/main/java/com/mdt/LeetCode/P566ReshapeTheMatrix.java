package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * <p>
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 * <p>
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * date: 7/08/22
 */
public class P566ReshapeTheMatrix {

    /**
     * my solution
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        var rowCount    = mat.length;
        var columnCount = mat[0].length;
        if (rowCount * columnCount != r * c) return mat;
        var result = new int[r][c];
        var matR   = 0;
        var matC   = 0;
        for (var i = 0; i < r; i++) {
            for (var j = 0; j < c; j++) {
                result[i][j] = mat[matR][matC];
                matC++;
                if (matC == columnCount) {
                    matC = 0;
                    matR++;
                }
            }
        }
        return result;
    }
}

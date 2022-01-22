package com.mdt.CrackingInterview.chapter1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;

import java.util.ArrayList;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 * <p>
 * date: 1/12/22
 */
public class Q8 {
    private static final Logger log = getLogger(Q8.class);

    public static void main(String[] args) {
        var q8 = new Q8();
        int[][] matrix = new int[][]{
                {0, 1, 2, 3, 4},
                {5, 4, 3, 2, 0},
                {6, 7, 0, 8, 9},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1}
        };
        var zeroMatrix = q8.zeroMatrix(matrix);
        printMatrix(zeroMatrix);

        int[][] matrix2 = new int[][]{
                {1, 1, 2, 3, 4},
                {5, 4, 3, 2, 0},
                {6, 7, 0, 8, 9},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 3, 1}
        };

        var zeroMatrix2 = q8.zeroMatrix(matrix2);
        printMatrix(zeroMatrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

     public int[][] zeroMatrix(int[][] matrix) {
        var cellArray = new ArrayList<Cell>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    cellArray.add(new Cell(i, j));
                }
            }
        }
        var m = matrix.length;
        var n = matrix[0].length;

        for (var cell : cellArray) {
            for (int i = 0; i < n; i++)
                 matrix[cell.getRow()][i] = 0;
            for (int i = 0; i < m; i++)
                 matrix[i][cell.getColumn()] = 0;
        }

        return matrix;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private class Cell {
        private int row;
        private int column;
    }
}

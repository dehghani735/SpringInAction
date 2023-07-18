package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * date: 6/18/22
 */
public class P463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        var counter = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i + 1 == grid.length) counter++;
                    else if (grid[i + 1][j] == 0) counter++;
                    if (i - 1 < 0) counter++;
                    else if (grid[i - 1][j] == 0) counter++;
                    if (j + 1 == grid[i].length) counter++;
                    else if (grid[i][j + 1] == 0) counter++;
                    if (j - 1 < 0) counter++;
                    else if (grid[i][j - 1] == 0) counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Nick's solution was more interesting
     *
     * @param grid
     * @return
     */
    public int islandPerimeter2(int[][] grid) {
        var counter = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    counter += 4;

                    if (i > 0 && grid[i - 1][j] == 1) counter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) counter -= 2;
                }
            }
        }
        return counter;
    }
}

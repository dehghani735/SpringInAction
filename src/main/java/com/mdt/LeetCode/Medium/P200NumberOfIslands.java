package com.mdt.LeetCode.Medium;

/**
 * Medium
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * date: 7/16/22
 */
public class P200NumberOfIslands {

    /**
     * Nick's solution: idea is that when you find a island, destroy it.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        var count = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        callBFS(grid, i + 1, j);
        callBFS(grid, i - 1, j);
        callBFS(grid, i, j + 1);
        callBFS(grid, i, j - 1);
    }
}

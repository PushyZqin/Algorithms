package leetcode.explore.queueStack.solution.islandCount;

import java.util.Arrays;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * @author Pushy
 * @since 2018/11/8 8:44
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                numIslandsDFS(grid, visited, i, j);
                count++;
            }
        }


        return 1;
    }

    void numIslandsDFS(char[][] grid, boolean[][] visited, int x, int y) {

    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        Solution solution = new Solution();
        solution.numIslands(grid);

    }


}

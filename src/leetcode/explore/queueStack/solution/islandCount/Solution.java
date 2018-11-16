package leetcode.explore.queueStack.solution.islandCount;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
 *
 * @author Pushy
 * @since 2018/11/8 8:44
 */
public class Solution {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslandsDFS(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void numIslandsDFS(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length) return;  // 不合法的坐标值
        if (y < 0 || y >= grid[0].length) return; // 不合法的坐标值
        if (grid[x][y] != '1' || visited[x][y]) return;  // 直到找到的值不为1为止

        visited[x][y] = true;  // 标记为访问过

        numIslandsDFS(grid, visited, x - 1, y);  // 左
        numIslandsDFS(grid, visited, x + 1, y);  // 右
        numIslandsDFS(grid, visited, x, y - 1);  // 下
        numIslandsDFS(grid, visited, x, y + 1);  // 上
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        Solution solution = new Solution();
        int result = solution.numIslands(grid);
        System.out.println(result);
    }


}

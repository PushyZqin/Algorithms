package site.pushy.algorithms.leetcode.explore.queueStack.islandCount;

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
                    numIslandsBFS(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void numIslandsBFS(char[][] grid, boolean[][] visited, int x, int y) {
        // 排除不合法的坐标值
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        // 查找的岛屿筛选条件，即要求周围的都是 1（陆地）
        if (grid[x][y] != '1' || visited[x][y]) return;

        visited[x][y] = true;  // 标记为访问过

        // 递归查找该位置的上下左右，如果上下左右都为1，则说明该 (x, y) 位置为岛屿
        numIslandsBFS(grid, visited, x - 1, y);  // 左
        numIslandsBFS(grid, visited, x + 1, y);  // 右
        numIslandsBFS(grid, visited, x, y - 1);  // 下
        numIslandsBFS(grid, visited, x, y + 1);  // 上
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

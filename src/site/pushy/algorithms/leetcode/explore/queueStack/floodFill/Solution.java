package site.pushy.algorithms.leetcode.explore.queueStack.floodFill;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/8 11:42
 */
public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor == oldColor) return image;

        DFS(image, newColor, oldColor, sr, sc);
        return image;
    }

    private void DFS(int[][] image, int newColor, int oldColor, int x, int y) {
        image[x][y] = newColor;

        if (x > 0 && image[x - 1][y] == oldColor) {
            DFS(image, newColor, oldColor, x - 1, y);
        }
        if (x < image.length - 1 && image[x + 1][y] == oldColor) {
            DFS(image, newColor, oldColor, x + 1, y);
        }
        if (y > 0 && image[x][y - 1] == oldColor) {
            DFS(image, newColor, oldColor, x, y - 1);
        }
        if (y < image[0].length - 1 && image[x][y + 1] == oldColor) {
            DFS(image, newColor, oldColor, x, y + 1);
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        Solution solution = new Solution();
        int[][] res = solution.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
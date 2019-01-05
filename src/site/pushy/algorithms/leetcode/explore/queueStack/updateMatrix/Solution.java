package site.pushy.algorithms.leetcode.explore.queueStack.updateMatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pushy
 * @since 2018/111/17 21:24
 */
public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 找到所有为0的坐标，并记录他们的坐标值
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (matrix[point[0]][point[1]] > count) {
                    matrix[point[0]][point[1]] = count;
                }
                offerOther(matrix, point, queue);
            }
            count++;
        }
        return matrix;
    }

    private void offerOther(int[][] matrix, int[] point, Queue<int[]> queue) {
        int x = point[0], y = point[1];
        if (x - 1 >= 0 && x - 1 < matrix.length && matrix[x - 1][y] == Integer.MAX_VALUE) {
            queue.offer(new int[]{x - 1, y});
        }
        if (x + 1 >= 0 && x + 1 <matrix.length && matrix[x + 1][y] == Integer.MAX_VALUE) {
            queue.offer(new int[]{x + 1, y});
        }
        if (y - 1 >= 0 && y - 1 <matrix[0].length && matrix[x][y - 1] == Integer.MAX_VALUE) {
            queue.offer(new int[]{x, y -1});
        }
        if (y + 1 >= 0 && y + 1 < matrix[0].length && matrix[x][y + 1] == Integer.MAX_VALUE) {
            queue.offer(new int[]{x, y + 1});
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] res = solution.updateMatrix(matrix);
        System.out.println("res：" + Arrays.deepToString(res));
    }

}
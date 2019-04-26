package site.pushy.algorithms.leetcode.explore.array.findDiagonalOrder;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2018/12/30 13:21
 */
public class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] res = new int[m * n];
        int x = 0;
        int y = 0;

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution solution = new Solution();
        int[] res = solution.findDiagonalOrder(matrix);
        System.out.println("res：" + Arrays.toString(res));
    }

}
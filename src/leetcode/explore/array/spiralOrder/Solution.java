package leetcode.explore.array.spiralOrder;

import java.util.*;

/**
 * @author Pushy
 * @since 2018/12/30 19:29
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        /* 每一步走完要对边界做出调整，并且判断是否满足退出的条件 */
        while (true) {
            /* 向左走 */
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;
            if (left > right || top > bottom) break;

            /* 向下 */
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;

            /* 向左 */
            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            /* 向上 */
            for (int i = bottom; i >= top; i--)
                res.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };

        Solution solution = new Solution();
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println("res: " + res);
    }

}
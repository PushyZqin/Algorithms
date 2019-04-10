package site.pushy.algorithms.leetcode.topInterviewQuesitonsIn2018.searchMatrix;

/**
 * @author Pushy
 * @since 2019/3/3 10:24
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int x = 0;
        int y = matrix.length - 1;
        // 从左下角开始，逐渐向右上角缩小范围
        // 每次遍历都判断当前遍历到的元素matrix[y][x]和目标值的大小
        while (y >= 0 && x < matrix[0].length) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {  // 比目标值小，往右移动
                x++;
            } else if (matrix[y][x] > target) {  // 比目标值大，往上移动
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 565;

        Solution solution = new Solution();
        boolean res = solution.searchMatrix(matrix, target);
        System.out.println("res：" + res);
    }

}
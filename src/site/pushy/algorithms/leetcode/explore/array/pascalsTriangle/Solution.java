package site.pushy.algorithms.leetcode.explore.array.pascalsTriangle;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pushy
 * @since 2018/12/30 18:09
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;

        for (int i = 0; i < numRows; i++) {
            /* 初始化每行的列表对象 */
            List<Integer> row = new LinkedList<>();

            for (int j = 0; j <= i; j++) {
                /* 根据杨辉三角的规律，当行数为0、列数为0，或者行数=列数时为1 */
                if (i == 0 || j == 0 || j == i) {
                    row.add(1);
                } else {
                    /* 计算出当前添加数，即是它左上方和右上方的数的和 */
                    int number = res.get(i - 1).get(j) + res.get(i - 1).get(j - 1);
                    row.add(j, number);
                }
            }

            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;

        Solution solution = new Solution();
        List<List<Integer>> res = solution.generate(numRows);

        for (List<Integer> row : res) {
            System.out.println(row);
        }
    }

}
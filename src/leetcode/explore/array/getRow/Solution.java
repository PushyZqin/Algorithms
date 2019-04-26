package site.pushy.algorithms.leetcode.explore.array.getRow;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/2 17:54
 */
public class Solution {

    /*public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);

        List<List<Integer>> triangle = new LinkedList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> row = new LinkedList<>();

            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || j == i) {
                    row.add(1);
                } else {
                    int number = triangle.get(i - 1).get(j) + triangle.get(i - 1).get(j - 1);
                    row.add(j, number);
                }
            }
            triangle.add(row);
        }
        return triangle.get(rowIndex);
    }*/

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(1);
            /* 控制双肩相加的次数，第三行1次，第四行两次 */
            for (int j = list.size() - 2; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int rowIndex = 3;

        Solution solution = new Solution();
        List<Integer> res = solution.getRow(rowIndex);
        System.out.println("res：" + res);
    }

}
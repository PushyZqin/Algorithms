package site.pushy.algorithms.leetcode.problemset._454_4Sum_II;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/23 9:18
 */
public class Solution {

    /**
     * 借助哈希表来优化嵌套循环，将时间复杂度从 O(n^4) 降低到 O(n^2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = - (c + d);
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.fourSumCount(
                new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println("res：" + res);
    }

}
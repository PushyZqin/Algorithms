package site.pushy.algorithms.leetcode.problemset._268_Missing_Number;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/11 19:46
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        double res = n * (n + 1) / 2;  // 防止溢出的风险
        for (int i = 0; i < n; i++) {
            res -= nums[i];
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.missingNumber(new int[]{0, 1});
        System.out.println("res：" + res);
    }

}
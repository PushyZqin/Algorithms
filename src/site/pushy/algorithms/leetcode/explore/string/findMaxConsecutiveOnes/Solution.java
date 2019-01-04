package site.pushy.algorithms.leetcode.explore.string.findMaxConsecutiveOnes;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/1 21:29
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                /* 和上一次最大的记录次数比较，如果大于max将把本次计数的值赋值给max */
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};

        Solution solution = new Solution();
        int res = solution.findMaxConsecutiveOnes(nums);
        System.out.println("res：" + res);
    }

}
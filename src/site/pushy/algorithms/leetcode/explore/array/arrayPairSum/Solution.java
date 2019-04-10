package site.pushy.algorithms.leetcode.explore.array.arrayPairSum;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/1 14:42
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};

        Solution solution = new Solution();
        int res = solution.arrayPairSum(nums);
        System.out.println("res：" + res);
    }

}
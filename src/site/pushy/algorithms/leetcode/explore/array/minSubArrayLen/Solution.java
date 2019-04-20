package site.pushy.algorithms.leetcode.explore.string.minSubArrayLen;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/1 21:49
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;  // 慢指针
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i]; // 把前i个元素累加起来，让它们的和超过s
            while (sum >= s) {
                res = Math.min(res, i - left + 1); // 记录i-left+1，即相加的元素个数
                sum -= nums[left]; // 依次剔除元素，使sum尽量接近s
                left++;
            }
        }
        return (res != Integer.MAX_VALUE) ? res : 0;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        Solution solution = new Solution();
        int res = solution.minSubArrayLen(s, nums);
        System.out.println("res：" + res);
    }

}
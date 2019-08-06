package leetcode.problemset._16_3Sum_Closest;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/7/15 12:19
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int abs = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < nums.length; i++) { // 固定一个数
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < abs) {
                    abs = Math.abs(sum - target);
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.threeSumClosest(new int[]{0, 1, 2}, 3);
        System.out.println("res：" + res);
    }
}
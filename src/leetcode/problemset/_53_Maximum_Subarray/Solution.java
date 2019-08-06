package leetcode.problemset._53_Maximum_Subarray;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/11 15:10
 */
public class Solution {

    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//
//        dp[0] = nums[0];
//        if (nums[0] > 0 && nums[1] > 0) dp[1] = nums[0] + nums[1];
//        else dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 1]);
//        }
//
//        System.out.println(Arrays.toString(dp));
//
//        return dp[n - 1];

        if (nums.length == 0) return -1;

        int res = Integer.MIN_VALUE;
        int fn = -1;
        for (int i = 0; i < nums.length; i++) {
            fn = Math.max(nums[i], fn + nums[i]);
            res = Math.max(fn, res);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)  // 没断
                sum += num;
            else // 断了
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("res：" + res);
    }

}
package leetcode.explore.queueStack.solution.findTargetSumWays;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * @author Pushy
 * @since 2018/11/17 12:18
 */
public class Solution {

    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        DFS(0, 0, nums, S);
        return result;
    }

    void DFS(int sum, int level, int[] nums, int S) {
        if (level == nums.length) {
            if (sum == S) result++;
            return;
        }
        DFS(sum + nums[level], level + 1, nums, S);
        DFS(sum - nums[level], level + 1, nums, S);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int res = solution.findTargetSumWays(nums, 3);

        System.out.println(res);
    }

}

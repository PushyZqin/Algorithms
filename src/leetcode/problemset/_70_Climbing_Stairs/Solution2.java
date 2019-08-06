package leetcode.problemset._70_Climbing_Stairs;

/**
 * @author Pushy
 * @since 2019/4/27 20:34
 */
public class Solution2 {

    /**
     * 用数组实现动态规划
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 因为每次遍历只需要保存两个变量值，可以不需要通过数组来实现
     */
    public static int climbStairs2(int n) {
        if (n <= 2) return n;

        int temp = 0;
        int m = 1, l = 2;

        for (int i = 3; i <= n; i++) {
            temp = m + l;
            m = l;
            l = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.climbStairs(3);
        System.out.println("res：" + res);
    }

}

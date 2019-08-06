package skill.dp;

/**
 * 斐波那契数列递归与动态规划实现
 *
 * @author Pushy
 * @since 2019/4/28 13:28
 */
public class Fibonacci {

    /**
     * 递归实现，时间复杂度为O(n^2)
     */
    public static int recursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return recursion(n - 1) + recursion(n - 2);
    }

    /**
     * 动态规划实现，将时间复杂度降到了O(n)
     */
    public static int dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = recursion(10);
        System.out.println(res);

        res = dp(10);
        System.out.println(res);
    }

}

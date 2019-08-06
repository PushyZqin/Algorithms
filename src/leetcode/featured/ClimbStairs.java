package leetcode.featured;

/**
 * @author Pushy
 * @since 2019/2/3 16:54
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1 || n <= 0) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(3));
    }

}

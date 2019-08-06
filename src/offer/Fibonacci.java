package offer;

/**
 * @author Pushy
 * @since 2019/5/27 10:57
 */
public class Fibonacci {

    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacciDP(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();
        int res = solution.fibonacci(3);
        System.out.println(res);
    }

}

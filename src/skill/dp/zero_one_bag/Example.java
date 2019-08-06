package skill.dp.zero_one_bag;

/**
 * @author Pushy
 * @since 2019/5/1 17:05
 */
public class Example {

    public static int solution(int[] costs, int[] wights, int n, int cap) {
        int[][] dp = new int[n + 1][cap + 1];

        // 当重量和物品为 0 时，价值为 0
        for (int i = 0; i <= cap; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j < wights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int w1 = dp[i - 1][j];
                    int w2 = dp[i - 1][j - wights[i]] + costs[i];
                    dp[i][j] = Math.max(w1, w2);
                }
            }
        }
        return dp[n][cap];
    }

    public static void main(String[] args) {
        int[] costs = {2, 3, 4, 5};   // 费用
        int[] wights = {3, 4, 5, 7};  // 价值
        int n = 3;
        int cap = 9;

        int res = solution(costs, wights, n, cap);
        System.out.println(res);
    }

}

package skill.dp;

/**
 * 假设您是个土豪，身上带了足够的1、5、10、20、50、100元面值的钞票。现在您的目标是凑出某个金额num，需要用到尽量少的钞票
 * @author Pushy
 * @since 2019/5/1 16:42
 */
public class MinRMB {

    public static int min(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        int cost;
        for (int i = 1; i <= num; i++) {
            cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) cost = Math.min(cost, dp[i - 1] + 1);
            if (i - 5 >= 0) cost = Math.min(cost, dp[i - 5] + 1);
            if (i - 11 >= 0) cost = Math.min(cost, dp[i - 11] + 1);
            dp[i] = cost;
        }
        return dp[num];
    }

    public static void main(String[] args) {
        int res = min(15);
        System.out.println(res);
    }

}

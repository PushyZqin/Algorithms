package skill.dp.max_number;

/**
 * 在一个数组arr中，找出一组不相邻的数字，使得最后的和最大。
 *
 * @author Pushy
 * @since 2019/4/28 15:37
 */
public class MaxNumber {

    public static int recursion(int[] arr, int n) {
        if (n == 0) return arr[0];
        if (n == 1) return Math.max(arr[0], arr[1]);

        int a = recursion(arr, n - 2) + arr[n];
        int b = recursion(arr, n - 1);
        return Math.max(a, b);
    }

    public static int dp(int[] arr) {
        int[] dp = new int[arr.length];
        int n = arr.length;

        dp[0] = arr[0];                   // 一个元素，和最大只能为arr[0]
        dp[1] = Math.max(arr[0], arr[1]); // 2个元素，取第一个与第二个元素较大的那位

        for (int i = 2; i < n; i++) {
            int a = dp[i - 2] + arr[i];
            int b = dp[i - 1];
            dp[i] = Math.max(a, b);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 9, 1};

        int res = recursion(arr, arr.length - 1);
        System.out.println(res);

        res = dp(arr);
        System.out.println(res);
    }

}

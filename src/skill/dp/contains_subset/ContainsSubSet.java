package skill.dp.contains_subset;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/28 16:08
 */
public class ContainsSubSet {

    /**
     * @param arr 数组
     * @param n   数组长度
     * @param s   目标值
     */
    public static boolean recursion(int[] arr, int n, int s) {
        if (s == 0) return true;    // 目标值为0时，返回true
        if (n == 0) return n == s;  // 当仅有一个元素时，只需要判断该元素是否和目标值相同即可

        // 如果当前元素会大于目标值的话，则无需考虑选当前元素的情况了
        if (arr[n] > s) return recursion(arr, n - 1, s);

        boolean a = recursion(arr, n - 1, s - arr[n]);  // 选当前元素
        boolean b = recursion(arr, n - 1, s);              // 不选当前元素
        return a || b;
    }

    public static boolean dp(int[] arr, int s) {
        int n = arr.length;

        // 建立二维数组，行表示target的取值，从0 ~ s；列表示数组的元素
        boolean[][] dp = new boolean[n][s + 1];
        for (int i = 0; i < dp.length; i++) { // 把每一行的第一列都设为true
            dp[i][0] = true;
        }
        // 将第一行的第arr[0]列设置为true
        // 这是因为：当i = 0时候，如果s = arr[0]的话，则可以凑成目标值；不等于的话则无法凑成目标值
        dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    boolean a = dp[i - 1][j - arr[i]]; // 选
                    boolean b = dp[i - 1][j];          // 不选
                    dp[i][j] = a || b;
                }
            }
        }

        return dp[n - 1][s];  // 返回右下角值
    }

    public static void printArr(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};

        boolean res = recursion(arr, arr.length - 1, 13);
        System.out.println(res);

        res = dp(arr, 13);
        System.out.println(res);
    }

}

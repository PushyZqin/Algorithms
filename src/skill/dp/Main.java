package skill.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/4/30 20:47
 */
public class Main {

    private static int solution(int[] arr, int n, int t) {
        Arrays.sort(arr);
        int[][] dp = new int[n][t + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        dp[0][arr[0]] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < t + 1; j++) {
                if (arr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
//                    int s = dp[i - 1][j - arr[i]]; // 选
//                    int us = dp[i - 1][j];         // 不选
//                    int sum = s + us;
//                    if (arr[i] == j) {
//                        sum++;
//                    }
//                    dp[i][j] = sum;
//                    int sum = 0;
//                    if (j == arr[i]) {
//                        sum++;
//                    } else {
//                        sum += dp[i - 1][j - arr[i]]; // 选
//                    }
//                    sum += dp[i - 1][j];         // 不选
//                    dp[i][j] = sum;
                }
            }
        }
        return dp[n - 1][t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strs = line.split(" ");
            int n = Integer.parseInt(strs[0]), t = Integer.parseInt(strs[1]);

            line = scanner.nextLine();
            strs = line.split(" ");
            int[] arr = new int[strs.length];

            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            int s = solution(arr, n, t);
            System.out.println(s);
        }

//        int res = solution(new int[]{1, 2, 3, 4, 5}, 5);
//        System.out.println(res);
    }

}

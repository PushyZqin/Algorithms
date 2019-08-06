package offer;

import java.util.Arrays;

public class JumpFloorII {

//    public int JumpFloorII(int target) {
//        return 1 << --target;
//    }

    public int JumpFloorII(int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j];
            }
            dp[i] = 1 + sum;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpFloorII s = new JumpFloorII();
        System.out.println(s.JumpFloorII(3));
    }

}

package leetcode.problemset._204_Count_Primes;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/23 15:55
 */
public class Solution {

    public int countPrimes0(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            int k = (int) Math.sqrt(i);
            for (int j = 2; j <= k; j++) {
                if (i % j == 0) { // 如果能被整除，则表明此数不是素数
                    flag = false;
                    break;
                }
            }
            if (flag) res++;
        }
        return res;
    }

    /**
     * 埃拉托斯特尼筛法求质数
     */
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) { // 将i的2倍、3倍、4倍...都标记为非素数
                    prime[j] = false;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countPrimes0(10);
        System.out.println("res：" + res);
    }

}
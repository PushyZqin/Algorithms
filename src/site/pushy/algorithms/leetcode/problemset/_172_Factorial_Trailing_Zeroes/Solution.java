package site.pushy.algorithms.leetcode.problemset._172_Factorial_Trailing_Zeroes;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/13 17:38
 */
public class Solution {

    public int trailingZeroes(int n) {
//        long fac = 1;
//        for (int i = 1; i <= n; i++) {
//            System.out.println(i);
//            fac *= i;
//        }
//        int res = 0;
//        for (; fac > 0; fac /= 10) {
//            if (fac % 10 == 0) res++;
//            else break;
//        }
//        return res;

        int res = 0, k = n;
        while (k > 1) {
            k /= 5;
            res += k;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.trailingZeroes(12);
        System.out.println("res：" + res);
    }

}
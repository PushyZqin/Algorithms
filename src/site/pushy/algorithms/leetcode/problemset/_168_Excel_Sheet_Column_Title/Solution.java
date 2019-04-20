package site.pushy.algorithms.leetcode.problemset._168_Excel_Sheet_Column_Title;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/13 16:39
 */
public class Solution {

    /**
     * 十进制转二十六进制...
     */
    public String convertToTitle(int n) {
        if (n <= 0) return "";

        StringBuilder res = new StringBuilder();
        for (; n > 0; n /= 26) {
            n--;
            int r = n % 26;
            char ch = (char) (r + 'A');
            res.append(ch);
        }
        return res.reverse().toString();
    }

    /**
     * 二十六进制转十进制
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = s.charAt(i) - 64;
            res += n * Math.pow(26, s.length() - i - 1);
        }
        return res;
    }

    public int titleToNumber2(String s) {
        int res = 0;
        long base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.convertToTitle(26);
        System.out.println("res：" + res);

        System.out.println(solution.titleToNumber("BA"));
    }

}
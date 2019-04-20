package site.pushy.algorithms.leetcode.explore.string.addBinary;

import java.util.*;

/**
 * @author Pushy
 * @since 2018/12/30 21:06
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        String strMin = a.length() < b.length() ? a : b;
        String strMax = a.length() < b.length() ? b : a;
        int lenMin = strMin.length(), lenMax = strMax.length();
        //补齐长度小的字符串前面的"0"
        if (lenMin != lenMax) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, len = lenMax - lenMin; i < len; i++) {
                sb.append("0");
            }
            strMin = sb.toString() + strMin;
        }

        int extra = 0;
        for (int i = lenMax - 1; i >= 0; i--) {
            int num = (strMin.charAt(i) - '0') + (strMax.charAt(i) - '0') + extra;
            if (num >= 2) {
                extra = 1;
                res.append(num - 2);
            } else {
                extra = 0;
                res.append(num);
            }
        }
        if (extra == 1) res.append("1");
        return res.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int carry = 0;

        while (la >= 0 || lb >= 0) {
            int sum = carry;
            if (la >= 0) {
                sum += (a.charAt(la--) - '0');
            }
            if (lb >= 0) {
                sum += (b.charAt(lb--) - '0');
            }
            res.append(sum % 2);  // 相加结果
            // 进位，如果是1那么carry=0，如果是2则要进位给下面一位+1
            carry = sum / 2;
        }
        if (carry != 0) res.append(1);  // 都相加完了，还要进位的情况
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        Solution solution = new Solution();
        String res = solution.addBinary2(a, b);
        System.out.println("res：" + res);
    }

}
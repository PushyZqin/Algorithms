package leetcode.problemset._12_Integer_to_Roman;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/7/15 12:57
 */
public class Solution {

    public String intToRoman(int num) {
        // 特殊数字 4、9、40、90、400、900 通过打表来实现
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] dict = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (num > 0 && i < dict.length) {
            if (num >= value[i]) {
                sb.append(dict[i]);
                num -= value[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.intToRoman(58);
        System.out.println("res：" + res);
    }
}
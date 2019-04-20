package site.pushy.algorithms.leetcode.problemset._709_To_Lower_Case;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/12 21:11
 */
public class Solution {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') { // 大写字母
                ch += (char) (ch + 32);  // 转换为小写
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.toLowerCase("HELLO");
        System.out.println("res：" + res);
    }

}
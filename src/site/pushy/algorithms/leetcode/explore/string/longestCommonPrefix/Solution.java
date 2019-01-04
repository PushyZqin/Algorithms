package site.pushy.algorithms.leetcode.explore.string.longestCommonPrefix;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/1 13:47
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        /* 找到最短的字符串 */
        String str = strs[0];
        for (String s : strs) {
            if (s.length() < str.length()) {
                str = s;
            }
        }

        String res = "";
        for (int i = 1; i < str.length() + 1; i++) {
            String prefix = str.substring(0, i);

            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                /* 判断是否有某一个前缀的子串没有 */
                if (!strs[j].substring(0, i).equals(prefix)) {
                    flag = false;
                }
            }
            /* 代表所有的字符串都有该前缀子串 */
            if (flag) {
                res = prefix;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        Solution solution = new Solution();
        String res = solution.longestCommonPrefix(strs);
        System.out.println("res：" + res);
    }

}
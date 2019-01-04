package site.pushy.algorithms.leetcode.explore.string.strStr;

import java.util.*;

/**
 * @author Pushy
 * @since 2018/12/31 18:44
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        int length = haystack.length() - needle.length() + 1;

        for (int i = 0; i < length; i++) {
            /* 通过截取出的haystack的he/el/ll/lo子串，和needle进行比较 */
            String temp = haystack.substring(i, i + needle.length());
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        Solution solution = new Solution();
        int res = solution.strStr(haystack, needle);
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.explore.hashTable.lengthOfLongestSubstring;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/18 9:39
 */
public class Solution {

    /**
     * 通过使用HashSet作为滑动窗口（可以将两个边界向某一个方向“滑动”的窗口），即[i, j)
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                /* j - i即在此之前的无重复的最长子串，并将与res的最大值重新复制给res */
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dvdf";

        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println("res：" + res);
    }

}
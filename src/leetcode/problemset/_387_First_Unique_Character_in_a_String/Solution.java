package site.pushy.algorithms.leetcode.problemset._387_First_Unique_Character_in_a_String;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/21 20:21
 */
public class Solution {

    /**
     * 执行用时 : 95 ms, 在First Unique Character in a String的Java提交中击败了31.19% 的用户
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    /**
     * 执行用时 : 15 ms, 在First Unique Character in a String的Java提交中击败了89.30% 的用户
     */
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 执行用时 : 2 ms, 在First Unique Character in a String的Java提交中击败了100.00% 的用户
     */
    public int firstUniqChar3(String s) {
        if (s == null || s.length() == 0) return -1;

        int res = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int idx = s.indexOf(i);
            if (idx != -1 && idx == s.lastIndexOf(i)) {
                res = Math.min(res, idx);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.firstUniqChar("loveleetcode");
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.problemset._409_Longest_Palindrome;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/24 15:36
 */
public class Solution {

    /**
     * 哈希表实现
     * 执行用时 : 15 ms, 在Longest Palindrome的Java提交中击败了36.14% 的用户
     */
    public int longestPalindrome(String s) {
        if (s.length() < 1) return s.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> vals = new ArrayList<>(map.values());

        int res = 0;
        boolean exitsSingle = false;    // 是否存在单一的字符
        for (int i = 0; i < vals.size(); i++) {
            int val = vals.get(i);
            if (val % 2 == 0) {
                res += val;
            } else { // 不是2的倍数，如3
                res += (val / 2) * 2;
                exitsSingle = true;
            }
        }
        return res + (!exitsSingle ? 0 : 1);
    }

    /**
     * 用数组优化一下
     * 执行用时 : 2 ms, 在Longest Palindrome的Java提交中击败了100.00% 的用户
     */
    public int longestPalindrome2(String s) {
        if (s.length() < 1) return s.length();

        char[] chars = s.toCharArray();
        int[] arr = new int['z' - 'A' + 1];
        for (int i = 0; i < chars.length; i++) {  // 记录字符的出现次数
            arr[chars[i] - 'A']++;
        }

        boolean exitsSingle = false;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                res += arr[i];
            } else { // 不是2的倍数，如3
                res += (arr[i] / 2) * 2;
                exitsSingle = true;
            }
        }
        return res + (!exitsSingle ? 0 : 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestPalindrome("ccc");
        System.out.println("res：" + res);
    }

}
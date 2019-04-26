package site.pushy.algorithms.leetcode.explore.hashTable.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Pushy
 * @since 2019/4/22 15:52
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                i = map.get(ch);
                if (count > max) max = count;
                count = 0;
                map.clear();
            } else {
                map.put(ch, i);
                count++;
            }
        }
        return Math.max(count, max);
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
                System.out.println(res);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    /**
     * 优化的滑动窗口
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();  // 定义字符到索引的映射

        for (int j = 0, i = 0; j < n; j++) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {  // 当我们找到重复的字符时，立即跳过该窗口
                i = Math.max(map.get(ch), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(ch, j + 1);
        }
        return ans;
    }

    /**
     * 优化的滑动窗口 2
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring2("pwwkew");
        System.out.println("res：" + res);
    }

}
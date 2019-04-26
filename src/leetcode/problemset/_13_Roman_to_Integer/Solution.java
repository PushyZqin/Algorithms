package site.pushy.algorithms.leetcode.problemset._13_Roman_to_Integer;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/13 15:36
 */
public class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < s.length() - 1 && map.get(ch) < map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i + 1)) - map.get(ch);
                i++;
            } else {
                res += map.get(ch);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "IL";

        Solution solution = new Solution();
        int res = solution.romanToInt(s);
        System.out.println("res：" + res);
    }

}
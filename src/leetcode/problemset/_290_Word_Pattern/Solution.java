package site.pushy.algorithms.leetcode.problemset._290_Word_Pattern;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/24 12:23
 */
public class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        if (str.isEmpty() && pattern.isEmpty()) return true;

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char pc = pattern.charAt(i);
            String sc = strs[i];

            if (map.containsKey(pc)) { // 查找哈希表的映射表能否和单词对应
                String val = map.get(pc);
                if (!val.equals(sc)) return false;
            } else if (map.containsValue(sc)) { // 排除掉多对一的情况
                return false;
            } else {
                map.put(pc, sc);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.wordPattern("abba", "dog dog dog dog");
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.explore.hashTable.firstUniqChar;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/15 18:38
 */
public class Solution {

//    public int firstUniqChar(String s) {
//        char[] chars = s.toCharArray();
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//
//        /* 通过HashMap用来存储每个字符在单词中出现的次数 */
//        for (char ch : chars) {
//            int value = hashMap.getOrDefault(ch, 0) + 1;
//            hashMap.put(ch, value);
//        }
//
//        /* 遍历字符数组，查询该字符在字符串中出现的次数 */
//        for (int i = 0; i < chars.length; i++) {
//            if (hashMap.get(chars[i]) == 1) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int res = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                res = Math.min(res, index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";

        Solution solution = new Solution();
        int res = solution.firstUniqChar(s);
        System.out.println("res：" + res);
    }

}
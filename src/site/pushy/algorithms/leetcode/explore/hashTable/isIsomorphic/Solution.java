package site.pushy.algorithms.leetcode.explore.hashTable.isIsomorphic;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/15 16:29
 */
public class Solution {

//    public boolean isIsomorphic(String s, String t) {
//        Map<Integer, Character> tMap = new HashMap<>();
//        Map<Character, Character> map = new HashMap<>();
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < t.length(); i++) {
//            tMap.put(i, t.charAt(i));
//        }
//
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (map.containsKey(chars[i])) {
//                if (map.get(chars[i]) != tMap.get(i)) {
//                    return false;
//                }
//            } else {
//                if (set.contains(tMap.get(i))) {
//                    return false;
//                } else {
//                    map.put(chars[i], tMap.get(i));
//                    set.add(tMap.get(i));
//                }
//            }
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < sa.length; i++) {
            char sc = sa[i];
            char tc = ta[i];

            /* 当map中存在sc某个字符对应的映射时，对比是否和tc相等，如果不相等则说明不是同构字符串 */
            if (map.get(sc) != null && map.get(sc) != tc) {
                return false;
            }

            /* 说明存在一对多的映射，例如 s = 'ab', t = 'aa' */
            if (!map.containsKey(sc) && map.containsValue(tc)) {
                return false;
            }

            map.put(sc, tc);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";

        Solution solution = new Solution();
        boolean res = solution.isIsomorphic(s, t);
        System.out.println("res：" + res);
    }

}
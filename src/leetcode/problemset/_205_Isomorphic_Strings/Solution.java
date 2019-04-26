package site.pushy.algorithms.leetcode.problemset._205_Isomorphic_Strings;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/21 18:43
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (map.containsKey(sc) && map.get(sc) != tc) {
                return false;
            }
            if (!map.containsKey(sc) && map.containsValue(tc)) {
                return false;
            }
            map.put(sc, tc);
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (map1[sc] != map2[tc]) return false;

            map1[sc] = i + 1;
            map2[tc] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isIsomorphic2("egg", "add");
        System.out.println("res：" + res);
    }

}
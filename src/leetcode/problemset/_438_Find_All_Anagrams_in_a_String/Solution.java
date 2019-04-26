package site.pushy.algorithms.leetcode.problemset._438_Find_All_Anagrams_in_a_String;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/24 16:55
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int left = 0, right = 0;

        int[] dict = new int[26], cur = new int[26];
        for (int i = 0; i < p.length(); i++) {
            dict[p.charAt(i) - 'a']++;
            cur[s.charAt(right++) - 'a']++;
        }
        if (equal(dict, cur)) res.add(left);

        while (right < s.length()) {
            cur[s.charAt(right++) - 'a']++;
            cur[s.charAt(left++) - 'a']--;
            if (equal(dict, cur)) {
                res.add(left);
            }
        }
        return res;
    }

    private boolean equal(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println("res：" + res);
    }

}
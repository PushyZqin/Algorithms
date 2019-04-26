package site.pushy.algorithms.leetcode.problemset._771_Jewels_and_Stones;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/22 15:09
 */
public class Solution {

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        for (char ch : J.toCharArray())
            set.add(ch);

        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) res++;
        }
        return res;
    }

    public int numJewelsInStones2(String J, String S) {
        int res = 0;
        int[] map = new int[100];

        for (int i = 0; i < J.length(); i++) {
            map[J.charAt(i) - 'A'] = 1;
        }

        for (int i = 0; i < S.length(); i++) {
            if (map[S.charAt(i) - 'A'] != 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numJewelsInStones2("aA", "aAAbbbb");
        System.out.println("res：" + res);
    }

}
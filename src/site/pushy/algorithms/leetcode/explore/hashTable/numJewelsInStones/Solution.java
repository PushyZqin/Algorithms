package site.pushy.algorithms.leetcode.explore.hashTable.numJewelsInStones;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/17 17:20
 */
public class Solution {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < J.length(); i++) set.add(J.charAt(i));

        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (set.contains(ch)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String J = "aA";        // 宝石的类型
        String S = "aAAbbbb";   // 拥有的石头

        Solution solution = new Solution();
        int res = solution.numJewelsInStones(J, S);
        System.out.println("res：" + res);
    }

}
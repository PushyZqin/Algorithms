package leetcode.problemset._455_Assign_Cookies;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/8 16:31
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.problemset._844_backspaceCompare;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/7 9:47
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        return getStack(S).equals(getStack(T));
    }

    private Stack<String> getStack(String tokens) {
        Stack<String> res = new Stack<>();

        for (Character ch : tokens.toCharArray()) {
            if (ch == '#') {
                if (!res.isEmpty()) res.pop();
            } else {
                res.push(ch.toString());
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";

        Solution solution = new Solution();
        boolean res = solution.backspaceCompare(S, T);
        System.out.println("res：" + res);
    }

}
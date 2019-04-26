package site.pushy.algorithms.leetcode.problemset._856_scoreOfParentheses;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/8 10:17
 */
public class Solution {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(res);
                res = 0;
            } else {
                res = stack.peek() + Math.max(res * 2, 1);
                stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "()()";

        Solution solution = new Solution();
        int res = solution.scoreOfParentheses(S);
        System.out.println("res：" + res);
    }

}
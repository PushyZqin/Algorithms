package site.pushy.algorithms.leetcode.problemset._682_calPoints;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/6 19:58
 */
public class Solution {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (String str : ops) {
            if (str.equals("+") && stack.size() > 1) {
                int top = stack.pop();
                int val = top + stack.peek();
                res += (val);
                stack.push(top);
                stack.push(val);
            } else if (str.equals("D") && !stack.isEmpty()) {
                int val = stack.peek() * 2;
                res += val;
                stack.push(val);
            } else if (str.equals("C") && !stack.isEmpty()) {
                res -= stack.pop();
            } else {
                int val = Integer.parseInt(str);
                res += val;
                stack.push(val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        Solution solution = new Solution();
        int res = solution.calPoints(ops);
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.explore.evalRPN;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/2 17:03
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> ops = Arrays.asList("+", "-", "*", "/");

        for (String s : tokens) {
            if (ops.contains(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                /* 减法和除法要特别注意，需要将num2作为被减数和被除数 */
                if (s.equals("+")) stack.push(num1 + num2);
                else if (s.equals("-")) stack.push(num2 - num1);
                else if (s.equals("*")) stack.push(num1 * num2);
                else if (s.equals("/")) stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "3", "-"};
        Solution solution = new Solution();
        int res = solution.evalRPN(tokens);
        System.out.println("res：" + res);
    }

}
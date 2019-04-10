package site.pushy.algorithms.leetcode.problemset._402_removeKdigits;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/7 11:07
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0'; // char to int
            while (!stack.isEmpty() && number < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(number);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String res = sb.reverse().toString();
        int start = 0;
        while (start < res.length() && res.charAt(start) == '0') { // 找到第一个不为零元素的下标值
            start++;
        }
        return res.equals("") ? "0" : res.substring(start);
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        Solution solution = new Solution();
        String res = solution.removeKdigits(num, k);
        System.out.println("res：" + res); // 200
    }

}
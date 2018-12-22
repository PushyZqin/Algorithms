package leetcode.explore.queueStack.solution.validBrackets;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2018/111/8 13:00
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {  // 如果是左括号放入栈中
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {  // 如果全部是右括号则为空
                    return false;
                }

                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isValid(")}");

        System.out.println(result);
    }

}

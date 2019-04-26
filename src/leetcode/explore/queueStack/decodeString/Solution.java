package site.pushy.algorithms.leetcode.explore.queueStack.decodeString;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/4/6 19:21
 */
public class Solution {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String res = "";
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') { // 如果遇到数字，则更新计数遍历count
                count = 10 * count + ch - '0';
                //count = Integer.parseInt(String.valueOf(ch));
            } else if (ch == '[') { // 如果遇到左括号，我们把当前count压入数字栈中，把当前res压入字符串栈
                numStack.push(count);
                strStack.push(res);
                count = 0; res = "";
            } else if (ch == ']') {
                // 如果遇到右括号，取出数字栈中的栈顶元素并赋值给k
                // 然后给字符串栈的顶元素循环加上k个字符串，并重新将累加过的字符串temp添加到res中
                int k = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int i = 0; i < k; i++) {
                    temp.append(res);
                }
                res = temp.toString();
            } else { // 如果是字母字符，则添加到res中
                res += ch;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";

        Solution solution = new Solution();
        String res = solution.decodeString(s);
        System.out.println("res：" + res);
    }

}

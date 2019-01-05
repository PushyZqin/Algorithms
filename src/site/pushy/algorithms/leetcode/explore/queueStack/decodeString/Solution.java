package site.pushy.algorithms.leetcode.explore.queueStack.decodeString;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2018/11/17 21:09
 */
public class Solution {

    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        int index = 0;
        int curNum = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(s.charAt(index))) {
                    curNum = 10 * curNum + (s.charAt(index) - '0');
                }
            } else if (ch == '[') {
                resStack.push(res);
                res = "";
                // 此push可以放在上面的while循环中
                countStack.push(curNum);
                curNum = 0;  // 注意
                index++;
                // 取出计算结果，和数字
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
                // 字母
            } else {
                res += s.charAt(index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.decodeString("3[a]2[bc]");
        System.out.println("res：" + res);
    }

}
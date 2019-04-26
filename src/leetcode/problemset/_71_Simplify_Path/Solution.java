package site.pushy.algorithms.leetcode.problemset._71_Simplify_Path;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/7 10:27
 */
public class Solution {

    public String simplifyPath(String path) {
        String newPath = removeDoubleSymbol(path);
        String[] strings = newPath.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            // 当 str 为 .. 时，出栈，代表返回上一个路径
            if (str.equals("")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (str.equals(".") || str.isEmpty()) {
                // do nothing
            } else {
                // 当 str 为普通字母时，入栈，代表进入下一个路径
                stack.push(str);
            }
        }
        if (stack.isEmpty()) return "/";  // 特殊情况，当栈为空时直接返回 /

        StringBuilder res = new StringBuilder();
        for (String str : stack) {
            res.append("/").append(str);
        }
        return res.toString();
    }

    // 将双斜杠替换为单斜杆
    public String removeDoubleSymbol(String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                while (i < path.length() && path.charAt(i) == '/') {
                    i++;
                }
                i--;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/../";

        Solution solution = new Solution();
        String res = solution.simplifyPath(path);
        System.out.println("res：" + res);
    }

}
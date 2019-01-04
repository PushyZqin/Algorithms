package site.pushy.algorithms.leetcode.explore.string.reverseWords2;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/2 20:46
 */
public class Solution {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");

        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();
            char[] chars = strings[i].toCharArray();
            for (int j = 0; j < chars.length / 2; j++) {
                char temp = chars[j];
                chars[j] = chars[length - 1 - j];
                chars[length - 1 - j] = temp;
            }

            strings[i] = String.valueOf(chars);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        Solution solution = new Solution();
        String res = solution.reverseWords(s);
        System.out.println("res：" + res);
    }

}
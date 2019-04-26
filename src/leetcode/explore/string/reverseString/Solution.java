package site.pushy.algorithms.leetcode.explore.string.reverseString;

/**
 * @author Pushy
 * @since 2019/1/1 14:24
 */
public class Solution {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();

        int length = chars.length;
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        Solution solution = new Solution();
        String res = solution.reverseString(s);
        System.out.println("res：" + res);
    }

}
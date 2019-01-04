package site.pushy.algorithms.leetcode.explore.string.reverseWords;

/**
 * @author Pushy
 * @since 2019/1/2 19:39
 */
public class Solution {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String str;
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            str = strings[i];
            if (!str.isEmpty()) {
                sb.append(str);
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = " 1";

        Solution solution = new Solution();
        String res = solution.reverseWords(s);
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.problemset._8_myAtoi;

/**
 * @author Pushy
 * @since 2019/2/4 10:12
 */
public class Solution {

    public int myAtoi(String str) {
        str = str.trim();
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        int res = Integer.parseInt(sb.toString());
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        String str = "91283472332";

        Solution solution = new Solution();
        int res = solution.myAtoi(str);
        System.out.println("res：" + res);
    }

}
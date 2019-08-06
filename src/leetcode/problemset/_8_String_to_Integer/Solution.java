package leetcode.problemset._8_String_to_Integer;

/**
 * @author Pushy
 * @since 2019/2/4 10:12
 */
public class Solution {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
            if (i == str.length()) return 0;
        }

        int sign = 1;
        if (str.charAt(i) == '+') i++;
        else if (str.charAt(i) == '-'){
            sign = -1;
            i++;
        }

        long res = 0;
        while (i < str.length()) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;

            res = res * 10 + digit;

            if (res > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * res);
    }

    public static void main(String[] args) {
        String str = "91283472332";

        Solution solution = new Solution();
        int res = solution.myAtoi(str);
        System.out.println("res：" + res);
    }

}
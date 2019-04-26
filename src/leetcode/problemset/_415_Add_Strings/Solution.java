package site.pushy.algorithms.leetcode.problemset._415_Add_Strings;

/**
 * @author Pushy
 * @since 2019/4/13 18:58
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int r = 0;

        while (i >= 0 || j >= 0) {
            int temp = 0;
            if (i >= 0) {
                temp += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                temp += num2.charAt(j--) - '0';
            }
            temp += r;
            if (temp >= 10) {
                res.append(temp - 10);
                r = 1;
            } else {
                res.append(temp);
                r = 0;
            }
        }
        if (r != 0) res.append("1");
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.addStrings("13", "7");
        System.out.println("res：" + res);
    }

}
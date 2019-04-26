package site.pushy.algorithms.leetcode.problemset._125_Valid_Palindrome;

/**
 * @author Pushy
 * @since 2019/2/4 9:54
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {  // 处理字符串，只保留数字和字母字符
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }

        String str = sb.toString();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        Solution solution = new Solution();
        boolean res = solution.isPalindrome(s);
        System.out.println("res：" + res);
    }

}
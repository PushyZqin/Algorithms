package site.pushy.algorithms.leetcode.problemset._28_Implement_strStr;

/**
 * @author Pushy
 * @since 2018/12/31 18:44
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int ll = haystack.length();
        int ls = needle.length();
        if (ll < ls) return -1;

        int max = haystack.length() - needle.length() + 1;
        for (int i = 0; i < max; i++) {
            /* 通过截取出的haystack的与needle等长度的子串，和needle进行比较是否相等 */
            String temp = haystack.substring(i, i + needle.length());
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int ll = haystack.length();
        int ls = needle.length();
        if (ll < ls) return -1;
        if (ls == 0) return 0;

        for (int i = 0; i < ll - ls + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < ls; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                    }
                }
                if (flag) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";

        Solution solution = new Solution();
        int res = solution.strStr(haystack, needle);
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.leetcode.problemset._58_Length_of_Last_Word;

/**
 * @author Pushy
 * @since 2019/4/13 11:24
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;

        String[] strings = s.split(" ");
        if (strings.length == 0)
            return 0;
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLastWord(" ");
        System.out.println("res：" + res);
    }

}
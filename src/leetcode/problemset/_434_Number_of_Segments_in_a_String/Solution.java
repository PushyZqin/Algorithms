package site.pushy.algorithms.leetcode.problemset._434_Number_of_Segments_in_a_String;

/**
 * @author Pushy
 * @since 2019/4/13 20:22
 */
public class Solution {

    public int countSegments(String s) {
        // Todo countSegments
        if (s == null || s.isEmpty()) return 0;
        return s.split(" ").length;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";

        Solution solution = new Solution();
        int res = solution.countSegments(s);
        System.out.println("res：" + res);
    }

}
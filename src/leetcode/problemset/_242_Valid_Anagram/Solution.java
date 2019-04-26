package site.pushy.algorithms.leetcode.problemset._242_Valid_Anagram;

/**
 * @author Pushy
 * @since 2019/4/23 17:13
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isAnagram("a", "b");
        System.out.println("res：" + res);
    }

}
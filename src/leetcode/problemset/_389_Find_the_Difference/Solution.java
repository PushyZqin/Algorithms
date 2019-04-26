package site.pushy.algorithms.leetcode.problemset._389_Find_the_Difference;

/**
 * @author Pushy
 * @since 2019/4/24 12:43
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (arr[ch - 'a'] == 0)
                return ch;
            else
                arr[ch - 'a']--;
        }
        return '\u0000';   // 没有不同的字符
    }

    public char findTheDifference2(String s, String t) {
        s = s + t;
        char[] c = s.toCharArray();

        int ch = 0;
        for (int i = 0; i < c.length; i++) {
            ch ^= c[i];  // 运用异或的性质，数字与自身异或结果为0
        }
        return (char) ch;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char res = solution.findTheDifference2("a", "aa");
        System.out.println("res：" + res);
    }

}
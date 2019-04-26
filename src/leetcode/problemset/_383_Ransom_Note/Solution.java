package site.pushy.algorithms.leetcode.problemset._383_Ransom_Note;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/13 19:49
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        List<Character> list = new ArrayList<>();
        for (char ch : magazine.toCharArray()) list.add(ch);

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = list.indexOf(ransomNote.charAt(i));
            if (idx == -1) return false;
            else {
                list.remove(idx);
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        for (char ch : ransomNote.toCharArray()) {
            boolean flag = false;
            for (int i = 0, length = chars.length; i < length; i++) {
                if (chars[i] == ch) {
                    flag = true;
                    chars[i] = '\u0000';
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aba";

        Solution solution = new Solution();
        boolean res = solution.canConstruct2(ransomNote, magazine);
        System.out.println("res：" + res);
    }

}
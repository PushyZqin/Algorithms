package leetcode.problemset._17_Letter_Combinations_of_a_Phone_Number;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/7/15 10:44
 */
public class Solution {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() != 0)
            backtrack("", digits, res);
        return res;
    }

    private void backtrack(String combination, String digits, List<String> res) {
        if (digits.length() == 0) {
            res.add(combination);
        } else {
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, digits.substring(1), res);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.letterCombinations("23");
        System.out.println("res：" + res);
    }
}
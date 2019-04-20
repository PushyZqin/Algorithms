package site.pushy.algorithms.leetcode.problemset._1002_Find_Common_Characters;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/11 15:28
 */
public class Solution {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        for (Character str : A[0].toCharArray())
            res.add(str.toString());

        for (int i = 0; i < A.length; i++) {
            List<String> tempList = new ArrayList<>();
            for (Character ch : A[i].toCharArray()) {
                String s = ch.toString();
                if (res.contains(s)) {
                    int idx = res.indexOf(s);
                    res.remove(idx);
                    tempList.add(s);
                }
            }
            res = tempList;
        }
        System.out.println(res);
        return res;
    }

    public List<String> commonChars2(String[] A) {
        List<String> res = new ArrayList<>();

        if (A == null || A.length <= 0) {
            return res;
        }
        int[] chars = new int[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = Integer.MAX_VALUE;
        }
        for (String a : A) {
            char[] content = a.toCharArray();
            int[] charsTemp = new int[26];
            // 统计每个字符串 各个字符数
            for (char c : content) {
                charsTemp[c - 97]++;
            }
            System.out.println(Arrays.toString(charsTemp) + " <= charsTemp");
            // 取小值
            for (int i = 0; i < 26; i++) {
                if (charsTemp[i] < chars[i]) {
                    chars[i] = charsTemp[i];
                }
            }
            System.out.println(Arrays.toString(chars) + " <= res");
        }

        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i]; k++) {
                res.add((char) (i + 'a') + "");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.commonChars2(new String[]{"cool", "lock", "cook"});
        System.out.println("res：" + res);
    }

}
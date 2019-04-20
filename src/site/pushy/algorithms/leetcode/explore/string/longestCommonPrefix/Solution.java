package site.pushy.algorithms.leetcode.explore.string.longestCommonPrefix;

import site.pushy.algorithms.datastructure.tree.TrieTree;

/**
 * @author Pushy
 * @since 2019/1/1 13:47
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        /* 找到最短的字符串 */
        String str = strs[0];
        for (String s : strs) {
            if (s.length() < str.length()) {
                str = s;
            }
        }

        String res = "";
        for (int i = 1; i < str.length() + 1; i++) {
            String prefix = str.substring(0, i);

            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                /* 判断是否有某一个前缀的子串没有 */
                if (!strs[j].startsWith(prefix)) {
                    flag = false;
                }
            }
            /* 代表所有的字符串都有该前缀子串 */
            if (flag) {
                res = prefix;
            }
        }
        return res;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int midLen = Integer.MAX_VALUE;  // 输入数据中最短的字符串的长度
        for (String str : strs) {
            midLen = Math.min(midLen, str.length());
        }
        int low = 1;
        int high = midLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str = strs[0].substring(0, len);
        for (String s : strs) {
            if (!s.startsWith(str)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        Solution solution = new Solution();
        String res = solution.longestCommonPrefix3(strs);
        System.out.println("res：" + res);
    }

}
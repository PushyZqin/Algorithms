package site.pushy.algorithms.leetcode.explore.hashTable.groupAnagrams;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/22 11:44
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String w = new String(chars);
            List<String> list = map.getOrDefault(w, new ArrayList<>());
            list.add(str);
            map.put(w, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char ch : s.toCharArray()) count[ch - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("res：" + res);
    }

}
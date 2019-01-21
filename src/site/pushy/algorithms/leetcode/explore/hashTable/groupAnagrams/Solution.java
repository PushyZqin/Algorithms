package site.pushy.algorithms.leetcode.explore.hashTable.groupAnagrams;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/17 16:35
 */
public class Solution {

    /**
     * 算法思路：通过排序将排序后的字符串作为键存入哈希表中
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);    // 对字符串进行排序

            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {  // 如果哈希表中不存在这个键，则初始化值的列表
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);  // 将字符串添加到对应的键对应的列表值中
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution solution = new Solution();
        List<List<String>> res = solution.groupAnagrams(strs);
        System.out.println("res：" + res);
    }

}
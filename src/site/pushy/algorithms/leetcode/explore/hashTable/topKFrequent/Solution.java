package site.pushy.algorithms.leetcode.explore.hashTable.topKFrequent;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/18 10:34
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        /* 将数组的元素根据哈希表中的key对值进行递增 */
        for (int i = 0; i < nums.length; i++) {
            freqMap.putIfAbsent(nums[i], 0);
            freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
        }
        /* 将Map中的键值对添加到列表中，并对列表根据键值对中的值进行排序 */
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(freqMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        /* 取出列表中的前k个键 */
        int count = 0;
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            res.add(entry.getKey());
            count++;
            if (count >= k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        Solution solution = new Solution();
        List<Integer> res = solution.topKFrequent(nums, k);
        System.out.println("res：" + res);
    }

}
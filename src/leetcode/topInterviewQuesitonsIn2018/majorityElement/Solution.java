package leetcode.topInterviewQuesitonsIn2018.majorityElement;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/3/3 9:54
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1;
            map.put(nums[i], value);
        }

        int res = -1;
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > num) {
                res = entry.getKey();
                num = entry.getValue();
            }
        }
        return res;
    }

    /**
     * 对上面的算法进行优化，因为题中所说众数是大于n / 2的元素，所有在向hashMap中添加元素的时候
     * 如果值（即元素出现的次数）大于n / 2时，那么则元素为众数
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length / 2;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int v = map.get(nums[i]);
                if (v == len) return nums[i];  // num[i]则为众数
                v++;
                map.put(nums[i], v);
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};

        Solution solution = new Solution();
        int res = solution.majorityElement2(nums);
        System.out.println("res：" + res);
    }

}
package site.pushy.algorithms.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
 *
 * @author Pushy
 * @since 2018/12/24 23:09
 */
public class SingleNumber {

    /**
     * 通过Hash表，建立 元素 - 出现次数的映射关系，然后在遍历map找到出现次数为1的元素
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            map.put(nums[i], (value == null ? 0 : value) + 1);
        }
        /* 找到值（出现次数）为1的元素 */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 通过异或操作符来实现，因为：
     * 1. 相同数字做 & 运算，会得到相同的数字
     * 2. 相同数字做 | 运算，会得到相同的数字
     * 3. 相同数字做 ^ 异或运算，会得到0
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        int res = 0;
        for (int e : nums) {
            /* 那些出现两次的数字将全部在异或中抵消掉了 */
            res = res ^ e;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};

        int result = SingleNumber.solution(nums);
        System.out.println(result);
    }

}
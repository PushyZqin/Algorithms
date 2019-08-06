package leetcode.explore.array.twoSum;

import java.util.Arrays;

/**
 * 看提交记录写的算法，执行时间1ms。。。
 * 通过双指针来查找
 *
 * @author Pushy
 * @since 2019/1/1 20:01
 */
public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;  // 左指针
        int r = numbers.length - 1;  // 右指针

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {  // 符合题意
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                /* 如果和大于目标数，则将右指针往前移动，将右指针指向的数减小 */
                r--;
            } else {
                /* 如果和小于目标数，则将左指针往后移动，将左指针指向的数增大 */
                l++;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] res = solution.twoSum(numbers, target);
        System.out.println("res：" + Arrays.toString(res));
    }

}

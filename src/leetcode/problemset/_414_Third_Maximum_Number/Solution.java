package site.pushy.algorithms.leetcode.problemset._414_Third_Maximum_Number;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/11 20:24
 */
public class Solution {

    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        boolean flag = true;
        int ctn = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE && flag) {
                ctn++;
                flag = false;
            }
            if (nums[i] > max1) { // 大于最大的元素
                ctn++;
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] < max1) { // 大于第二大元素
                ctn++;
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) { // 大于第三大元素
                ctn++;
                max3 = nums[i];
            }
        }
        return ctn >= 3 ? max3 : max1;
    }

    public int thirdMax2(int[] nums) {
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) arr[i] = -1;

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (j != 0 && nums[i] < arr[j]) {
                    arr[j - 1] = nums[i];
                    flag = true;
                    break;
                } else if (j !=0 && nums[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (arr[2] == -1)
                    arr[2] = nums[i];
                else {
                    int idx = 2;
                    while (idx > 0 && arr[idx] != -1) {
                        arr[idx - 1] = arr[idx];
                        idx--;
                    }
                    arr[2] = nums[i];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[0] != -1 ? arr[0] : arr[2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.thirdMax(new int[]{1, 2, 2, 3});
        System.out.println("res：" + res);
    }

}
package leetcode.problemset._26;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/8/1 21:45
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[idx++] = nums[i];
                set.add(nums[i]);
            }
        }
        return idx;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int res = solution.removeDuplicates(arr);
        System.out.println("res：" + res);

        System.out.println(Arrays.toString(arr));
    }
}
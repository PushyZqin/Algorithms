package site.pushy.algorithms.leetcode.explore.array.removeElement;

/**
 * @author Pushy
 * @since 2019/1/1 20:28
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int j = 0;  // 慢指针，指向下一次元素添加的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        Solution solution = new Solution();
        int res = solution.removeElement(nums, val);
        System.out.println("res：" + res);
    }

}
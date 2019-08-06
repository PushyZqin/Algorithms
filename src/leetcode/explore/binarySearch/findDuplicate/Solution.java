package src.leetcode.explore.binarySearch.findDuplicate;

/**
 * @author Pushy
 * @since 2019/1/21 16:11
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = countNumber(nums, mid);

            if (count > mid)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    /**
     * 计算数组中 1 ~ mid的元素个数
     */
    public int countNumber(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            if (num <= mid)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        Solution solution = new Solution();
        int res = solution.findDuplicate(nums);
        System.out.println("res：" + res);
    }

}
package leetcode.problemset._162_Find_Peak_Element;

/**
 * @author Pushy
 * @since 2019/1/19 19:33
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;

//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//        return nums.length - 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return i - 1;
        }
        return nums.length - 1;
    }

    /**
     * 二分查找的高级用法，终止条件为left == right，向右查找为 r = mid
     */
    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // left == right
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};

        Solution solution = new Solution();
        int res = solution.findPeakElement(nums);
        System.out.println("res：" + res);
    }

}
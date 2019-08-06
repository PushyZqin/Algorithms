package leetcode.explore.array.pivotIndex;

/**
 * @author Pushy
 * @since 2018/12/30 11:08
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = 0;

        /* 将所有的数都先添加都sum总和当中 */
        for (int num : nums) {
            rightSum += num;
        }
        /* 减去第一个数 */
        rightSum -= nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == rightSum) {  // 如果左侧和等于右侧和，则该元素为中心索引
                return i;
            }
            /* 当该元素不为中心索引时，将左侧和加上加上当前元素，将右侧和减去当前元素 */
            leftSum += nums[i];
            if (i + 1 < nums.length) {  // 防止数组越界
                rightSum -= nums[i + 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        Solution solution = new Solution();
        int res = solution.pivotIndex(nums);
        System.out.println("res：" + res);
    }

}
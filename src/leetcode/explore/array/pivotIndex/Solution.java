package leetcode.explore.array.pivotIndex;

/**
 * @author Pushy
 * @since 2018/11/10 14:12
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        int preSum = 0;
        int rearSum = 0;

        for (int value : nums) {
            rearSum += value;
        }

        rearSum -= nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (preSum == rearSum) {
                return i;
            }
            preSum += nums[i];  // 每当该元素不是中心索引，都将值相加到preSum中
            if (i + 1 < nums.length) {
                rearSum -= nums[i + 1];  // 将rearSum减去下一个判断的数，则rearSum即是下一个元素右边的总和
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});

        System.out.println(result);
    }

}

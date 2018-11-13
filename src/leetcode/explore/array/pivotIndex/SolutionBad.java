package leetcode.explore.array.pivotIndex;

/**
 * 采用最简单的方法，循环数组，算出循环的当前元素前面的所有元素和和后面所有元素的和
 *
 * @author Pushy
 * @since 2018/11/10 13:52
 */
public class SolutionBad {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int preSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                preSum += nums[j];
            }
            
            int rearSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                rearSum += nums[j];
            }

            if (preSum == rearSum) {
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        SolutionBad solution = new SolutionBad();
        int result = solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});

        System.out.println(result);
    }

}
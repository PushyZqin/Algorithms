package site.pushy.algorithms.leetcode.explore.array.dominantIndex;

/**
 * @author Pushy
 * @since 2018/12/30 11:31
 */
public class Solution {

    public int dominantIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int temp = nums[j] * 2;
                    if (nums[i] < temp) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 看的别人的解法
     */
    public int dominantIndex2(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int maxIndex = -1,   // 最大的数索引
                max = -1,    // 最大的数
                less = -1;   // 第二大的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {  // 如果比最大的数大，将当前值赋值给max，并记录下它的index
                less = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > less) {  // 如果比第二大数大，将当前值赋值给less
                less = nums[i];
            }
        }
        /* 判断最大的数是否大于第二大的数的两倍，也就可以说明大于数组中的所有数的两倍了 */
        return max >= (less + less) ? maxIndex : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
//        int[] nums = {1, 2, 3, 4};

        Solution solution = new Solution();
        int res = solution.dominantIndex(nums);
        System.out.println("res：" + res);
    }

}
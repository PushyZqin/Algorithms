package leetcode.explore.array.moveZeroes;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/2 21:10
 */
public class Solution1 {

    /**
     * 遍历数组，遇到零则记录zeroNum递增，如果不为0则与最近遇到的0交换位置
     * 这个算法有点类冒泡排序，将零一步一步地移动到最后边
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else if (zeroNum != 0) {
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /**
     * 该算法先将不为0的元素全部他移动到最前面，然后再填充在数组后面 zeroNum-1 个0元素
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int zeroNum = 0;

        /* 将不为零的元素移动到数组的最前边 */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroNum] = nums[i];
                zeroNum++;
            }
        }
        
        /* 填充零元素 */
        while (zeroNum < nums.length) {
            nums[zeroNum] = 0;
            zeroNum++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        Solution1 solution = new Solution1();
        solution.moveZeroes1(nums);

        System.out.println(Arrays.toString(nums));
    }

}
package simple.array;

import java.util.Arrays;

/**
 * 将一个数组的元素，其中是0的，放在数组的最后
 *
 * @author Pushy
 * @since 2018/12/25 11:53
 */
public class MoveZeros {

    public static void solution(int[] nums) {
        int count = 0;

        /* 将非0的数字向前移动 */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];  // 向前移动的个数即已经查找的0的个数，移动的位置为 i - count
            }
        }

        /* 将所有的0填充到数组的末尾 */
        int j = nums.length - count;
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 7, 3, 0, 9, 10};
        MoveZeros.solution(nums);

        System.out.println(Arrays.toString(nums));
    }

}
package nowcoder.max_multiply;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/5/8 14:23
 * @question https://www.nowcoder.com/questionTerminal/5f29c72b1ae14d92b9c3fa03a037ac5f
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextLong();
        }
        long res = solution(nums);
        System.out.println(res);
    }

    /**
     * 通过将数组快排后，找出第一大、第二大、第三大、第一小、第二小的数
     * 最大乘积只有两种情况：
     * 1. 第一大 * 第二大 * 第三大（全正数或全负数的情况）
     * 2. 第一小 * 第二小 * 第一大 (两个负数 * 一个整数的情况)
     */
    private static long solution(long[] nums) {
        Arrays.sort(nums);

        long max1 = nums[nums.length - 1];
        long max2 = nums[nums.length - 2];
        long max3 = nums[nums.length - 3];

        long min1 = nums[0], min2 = nums[1];

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    /**
     * 通过O(n)的时间复杂度找到这五个数
     */
    private static long solution2(long[] nums) {
        long max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        long min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

}

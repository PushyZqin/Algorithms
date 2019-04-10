package site.pushy.algorithms.leetcode.topInterviewQuesitonsIn2018.majorityElement;

/**
 * @author Pushy
 * @since 2019/3/3 10:07
 */
public class ExcellentSolution {

    /**
     * 使用摩尔投票法，将第一个数字假设为众数，然后把计数器设为1，比较下一个数和次数是否相等
     * 若相等则计数器+1，反之-1
     * 然后看此时计数器的值，若为零，则将下一个值设为候选众数，直到遍历完数组所有元素
     */
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int num : nums) {
            if (count == 0) res = num;
            if (res == num) count++;
            else count--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        ExcellentSolution solution = new ExcellentSolution();
        int res = solution.majorityElement(nums);
        System.out.println("res：" + res);
    }

}

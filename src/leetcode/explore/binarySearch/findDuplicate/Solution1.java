package site.pushy.algorithms.leetcode.explore.binarySearch.findDuplicate;

/**
 * @author Pushy
 * @since 2019/1/26 10:48
 */
public class Solution1 {

    /**
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     即按照寻找链表环入口的思路来做
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast)
                break;
        }

        // 让双指针以相同的速度移动，最后相遇的点即为环的入口
        int finder = 0;
        while (true) {
            slow = nums[slow];
            finder = nums[finder];
            if (slow == finder)
                return slow;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        Solution1 solution = new Solution1();
        int res = solution.findDuplicate(nums);
        System.out.println("res：" + res);
    }

}

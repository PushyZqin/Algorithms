package site.pushy.algorithms.leetcode.explore.binarySearch.searchRotate;

/**
 * @author Pushy
 * @since 2019/1/19 15:50
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            return -1;
        }

        int rotate = getRotate(nums);
        int[] arr = orderArray(nums, rotate);

        /* 二分法求元素的索引 */
        int left = 0, right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target)
                right = mid - 1;
            else if (arr[mid] < target)
                left = mid + 1;
            else {
                index = mid;
                break;
            }
        }

        /* 此时的Index为转换后数组的索引，需要通过计算出原始元素的索引，才是方法的返回值 */
        if (index == -1) return -1;

        if (index + rotate > nums.length - 1)  // 前面旋转的部分
            return index + rotate - nums.length;
        return index + rotate;  // 后面未旋转的部分
    }

    /**
     * 计算旋转点的下标
     */
    public int getRotate(int[] nums) {
        int res = 0;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] < nums[i-1]){
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 将旋转数组转换为原始的升序数组，并返回转换后的数组
     */
    public int[] orderArray(int[] nums, int rotate) {
        int[] arr = new int[nums.length];
        for (int i = rotate; i < nums.length; i++) {  // 填充后面未旋转的部分
            arr[i - rotate] = nums[i];
        }
        for (int i = 0; i < rotate; i++) {  // 填充前边旋转的部分
            arr[i + nums.length - rotate] = nums[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 0;

        long start = System.nanoTime();
        Solution solution = new Solution();
        int res = solution.search(nums, target);
        long end = System.nanoTime();
        System.out.println("res：" + res);

        System.out.println("Time ：" + (end - start));
    }

}
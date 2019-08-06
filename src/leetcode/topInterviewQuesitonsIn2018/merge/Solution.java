package leetcode.topInterviewQuesitonsIn2018.merge;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/3/3 10:40
 */
public class Solution {

    /**
     * 因为两个数组都是排好序的，所以我们从两个数组的末尾元素开始相互比较，大的就被放置在num1的第k个位置（最大的元素）
     * 然后以此类推
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // 指向初始nums1末尾的指针
        int j = n - 1;         // 指向初始nums2末尾的指针
        int k = m + n - 1;     // 指向最终num1末尾的指针

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {  // nums1[i] <= nums2[j]
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // 如果num2还存在没有添加的元素，则全部添加到num1中
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
        int[] nums1 = {2,0};
        int[] nums2 = {1};

        Solution solution = new Solution();
        solution.merge(nums1, 1, nums2, 1);

        System.out.println("res：" + Arrays.toString(nums1));
    }

}
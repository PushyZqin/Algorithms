package site.pushy.algorithms.simple.sort.quicksort;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * 介绍：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 即在数组中找一个支点(任意),经过一趟排序后，支点左边的数都要比支点小，支点右边的数都要比支点大！
 * <p>
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * @author Pushy
 * @since 2018/12/24 11:08
 */
public class QuickSort1 {

    public static void quickSort(int[] array, int left, int right) {
        int dp;

        if (left < right) {
            dp = partition(array, left, right);

            System.out.println(dp);
//            quickSort(array, left, dp - 1);
//            quickSort(array, dp + 1, right);
        }
    }

    public static int partition(int n[], int left, int right) {
        int pivot = n[left];   // 枢纽记录

        while (left < right) {
            while (left < right && n[right] >= pivot) {
                right--;
            }
            if (left < right) {
                n[left++] = n[right];
            }
            while (left < right && n[left] <= pivot) {
                left++;
            }
            if (left < right) {
                n[right--] = n[left];
            }
        }
        n[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 4};

        QuickSort1.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}

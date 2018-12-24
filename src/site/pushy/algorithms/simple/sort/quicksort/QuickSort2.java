package site.pushy.algorithms.simple.sort.quicksort;

import java.util.Arrays;

/**
 * 快速排序，通过选取中间的数作为基准数
 *
 * @author Pushy
 * @since 2018/12/24 13:18
 */
public class QuickSort2 {

    /**
     * 递归调用的方法
     * @param arr
     * @param L
     * @param R
     */
    public static void quickSort(int[] arr, int L, int R) {
        int left = L;
        int right = R;
        int pivot = arr[(L + R) / 2];  //支点

        // 左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (left <= right) {
            // 直到寻找到比支点大的数
            while (pivot > arr[left])
                left++;
            // 直到寻找到比支点小的数
            while (pivot < arr[right])
                right--;
            // 此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        // 上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。

        // “左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < right)
            quickSort(arr, L, right);
        // “右边”再做排序，直到右边剩下一个数(递归出口)
        if (left < R)
            quickSort(arr, left, R);
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 4, 1};

        QuickSort2.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}

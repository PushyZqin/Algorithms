package skill.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 介绍；是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序。
 * 时间复杂度为O(n^2)。是稳定的排序方法。
 *
 * @author Pushy
 * @since 2018/12/24 10:39
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        int temp;

        /* 控制需要排序的趟数，从1开始是因为把第0位看成是有效数据 */
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];

            int j = i;
            // 从已经排序的序列最右边开始比较，找到比其小的数
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];  // 往后移动一个位置
                j--;                  // 不断往前，直到退出循环
            }
            /* 退出了循环代表找到了合适的位置，将当前数据插入合适的位置中 */
            if (j != i) arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4};

        InsertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

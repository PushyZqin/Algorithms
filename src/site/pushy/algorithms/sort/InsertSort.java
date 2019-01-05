package site.pushy.algorithms.simple.sort;

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

    public static int[] basic(int[] array) {
        int temp;

        /* 控制需要排序的趟数，从1开始是因为把第0位看成是有效数据 */
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            while (i >= 1 && array[i - 1] > temp) {
                array[i] = array[i - 1];  // 往后退一个位置，让当前数据与之前前位进行比较
                i--;  // 不断往前，直到退出循环
            }
            /* 退出了循环代表找到了合适的位置，将当前数据插入合适的位置中 */
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 4};

        int[] result = InsertSort.basic(array);
        System.out.println(Arrays.toString(result));
    }

}

package site.pushy.algorithms.simple.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 介绍：选择排序(Selection sort)是一种简单直观的排序算法。
 * 它的工作原理是每一次从待排序的数据元素中选出最小(或最大)的一个元素，存放在序列的起始(末尾)位置，直到全部待排序的数据元素排完。
 * 选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。
 *
 * @author Pushy
 * @since 2018/12/23 23:29
 */
public class SelectionSort {

    public static int[] basic(int[] array) {
        int pos;  // 记录当前趟数的最大值的角标
        int temp;

        for (int i = 0; i < array.length; i++) {  // 控制需要排序的趟数
            pos = 0;
            for (int j = 0; j < array.length - i; j++) {  // 控制遍历数组的个数并得到最大数的角标
                if (array[j] > array[pos]) {
                    pos = j;
                }
            }
            // 交换值
            temp = array[pos];  // 拿到该趟的最大值
            /*
                将该趟的最大值放在已经排序的元素的最前面，例如第一趟，将最大值放在最后一位；
                第二趟，放在倒数第二位
             */
            array[pos] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 4};

        int[] result = SelectionSort.basic(array);
        System.out.println(Arrays.toString(result));
    }

}

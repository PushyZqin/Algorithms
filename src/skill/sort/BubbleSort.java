package site.pushy.algorithms.skill.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 介绍：是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名。
 *
 * @author Pushy
 * @since 2018/12/23 22:21
 */
public class BubbleSort {

    /**
     * 基础版本
     */
    public static int[] basic(int[] array) {
        int temp;

        for (int i = 0; i < array.length; i++) { // 排序的趟数
            for (int j = 0; j < array.length - i - 1; j++) {  // 当前趟数需要比较的次数
                /* 将前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换 */
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序升级版
     * 如果在某趟排序中没有发生交换位置，那么我们可以认为该数组已经排好序了。
     */
    public static int[] upgrade(int[] array) {
        int temp;
        boolean isChange;  // 记录是否发生了置换

        for (int i = 0; i < array.length - 1; i++) {
            isChange = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    /* 如果进到这里面了，说明发生置换了 */
                    isChange = true;
                }
            }
            /* 如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了 */
            if (isChange) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 4};

        int[] result = BubbleSort.upgrade(array);
        System.out.println(Arrays.toString(result));
    }
}

package site.pushy.algorithms.sort.quicksort;

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

    /**
     * 递归调用函数
     *
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high) {
        int pos;

        if (low < high) {
            /* 将数组分为两部分，交换完毕后记录支点的角标 */
            pos = partition(array, low, high);
            /* 然后再劈开两半进行递归调用 */
            quickSort(array, low, pos - 1); // 递归排序左子数组
            quickSort(array, pos + 1, high); // 递归排序右子数组
        }
    }

    /**
     * 将数组划分，比支点小的划分到左端，比支点大的划分到右端
     * high-- 是为了找到一个比支点小的数
     * low++ 是为了找到一个比支点大的数
     */
    public static int partition(int array[], int low, int high) {
        int pivot = array[low];   // 将第一个元素作为支点

        while (low < high) {
            while (low < high && array[high] >= pivot) {  // 直到寻找到比支点小的数
                high--;
            }
            array[low] = array[high];  // 交换比支点小的记录到左端
            while (low < high && array[low] <= pivot) {  // 直到寻找到比支点大的数
                low++;
            }
            array[high] = array[low];  // 交换比支点大的记录到右端
        }
        array[low] = pivot;
        return low;   // 返回支点的角标
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 4};

        QuickSort1.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}

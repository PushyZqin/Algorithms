package site.pushy.algorithms.sort;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/2/13 11:21
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        // 初始增量为 length / 2，每次增量都减为原来的一半
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 对分组的序列执行插入排序，直至完毕
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};

        ShellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

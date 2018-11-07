package basic.sort;

import java.util.Arrays;


public class Sort {

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void insertSort() {
        int[] arr = {57, 68, 59, 52};

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        System.out.println("Select basic.sort result is " + Arrays.toString(arr));
    }

    /**
     * 简单选择排序实现
     */
    public static void selectSort() {
        int[] arr = {57, 68, 59, 52};

        for (int i = 0; i < arr.length; i++) {  // 循环数组中的每个元素
            int min = i;   // mix 用于存放较小元素的数组下标
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) { // 循环当前元素后的所有元素
                if (arr[j] < temp) {
                    temp = arr[j];
                    min = j;  // 记下此次循环的最小元素的索引值
                }
            }
            /* 交换元素，将此次循环的最小值放到第i个位置 */
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Select basic.sort result is " + Arrays.toString(arr));
    }

    /**
     * 冒泡排序算法实现
     * 实现原理：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换
     */
    public static void bubbleSort() {
        int[] arr = {57, 68, 59, 52};

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {  // 循环数组中的每个元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Bubble basic.sort result is " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        insertSort();
        selectSort();
        bubbleSort();
    }


}

package site.pushy.algorithms.simple.array;

import java.util.Arrays;

/**
 * 将一个数组逆序输出
 *
 * @author Pushy
 * @since 2018/12/28 19:38
 */
public class ReverseArray {

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int end = arr.length - 1 - i;
            if (i > end) {
                break;
            }
            int temp = arr[end];
            arr[end] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void solution1(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; ) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3};
        ReverseArray.solution(arr);
    }

}
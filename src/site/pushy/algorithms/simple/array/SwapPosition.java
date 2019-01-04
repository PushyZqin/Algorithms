package site.pushy.algorithms.simple.array;

import java.util.Arrays;

/**
 * 有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 *
 * @author Pushy
 * @since 2018/12/29 10:16
 */
public class SwapPosition {

    /**
     * 通过迭代复制数组元素的方式来实现
     * @param arr
     * @param m
     */
    public static void solution(int[] arr, int m) {
        int n = arr.length;

        int[] b = new int[m];
        for (int i = 0; i < m; i++) { // 将数组arr的第n-m+i位~第n-1位移动到数组b
            b[i] = arr[n - m + i];
        }
        for (int i = n - 1; i >= m; i--) {  // 将数组arr的第0位~第n-1-m位向后移动m位
            arr[i] = arr[i - m];
        }
        for (int i = 0; i < m; i++) {  // 将数组b中的所有数移动到数组arr对应的位置
            arr[i] = b[i];
        }
    }

    /**
     * 通过System.arraycopy骚操作的方法来实现，缺点是不容易理解
     * @param arr
     * @param m
     */
    public static void solution1(int[] arr, int m) {
        int n = arr.length;

        int[] b = new int[m];
        System.arraycopy(arr, n - m - 0, b, 0, m);
        System.arraycopy(arr, m - m, arr, m, n - m);
        System.arraycopy(b, 0, arr, 0, m);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 4, 3, 9, 18};
        SwapPosition.solution(arr, 3);

        System.out.println("位移后的数组为：" + Arrays.toString(arr));
    }

}
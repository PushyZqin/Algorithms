package skill.sort;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/5/7 11:37
 */
public class BucketSort {

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void sort(int[] arr) {
        int max = findMax(arr);

        for (int i = 1; max / i > 0; i *= 10) {
            int[][] buckets = new int[arr.length][10];
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] / i) % 10;
                buckets[j][num] = arr[j];
            }

            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < arr.length; l++) {
                    if (buckets[l][j] != 0) {
                        arr[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 10};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}

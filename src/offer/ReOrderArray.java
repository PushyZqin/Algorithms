package offer;

import java.util.Arrays;

public class ReOrderArray {

    // 插入排序思想， 时间复杂度 O(n)，空间复杂度 O(1)
    public void reOrderArray(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            if (arr[i] % 2 == 1) {
                int j = i;
                while (j >= 1 && arr[j - 1] % 2 == 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                if (j != i) arr[j] = temp;
            }
        }
    }

//    public void reOrderArray(int [] arr) {  // 时间复杂度 O(3n)
//        int[] res = new int[arr.length];
//
//        int idx = 0;
//        for (int num : arr) {
//            if (num % 2 == 1) res[idx++] = num;
//        }
//        for (int num : arr) {
//            if (num % 2 == 0) res[idx++] = num;
//        }
//
//        System.arraycopy(res, 0, arr, 0, res.length);
//    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 3, 7, 6};
        ReOrderArray s = new ReOrderArray();
        s.reOrderArray(arr);

        System.out.println(Arrays.toString(arr));
    }

}

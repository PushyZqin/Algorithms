package offer;

import java.util.HashMap;
import java.util.Map;

public class FindNumsAppearOnce {

    // 通过哈希表来实现，时间复杂度为 O(n)，空间复杂度为O(n)
//    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : array)
//            map.put(num, map.getOrDefault(num, 0) + 1);
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                if (num1[0] == 0) num1[0] = entry.getKey();
//                else num2[0] = entry.getKey();
//            }
//        }
//    }

    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int n = array.length;
        if (n == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int bitResult = 0;
        for (int i = 0; i < n; i++) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);

        for (int i = 0; i < n; i++) {
            if (isBit(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找到最低位第一个为1的位的索引值
     */
    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult = bitResult >> 1;  // 右移一位
            index++;
        }
        return index;
    }

    /**
     * 判断num的index位上是否为1
     */
    private boolean isBit(int num, int index) {
        return ((num >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce s = new FindNumsAppearOnce();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        s.FindNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);

        System.out.println(num1[0] + " " + num2[0]);
    }

}

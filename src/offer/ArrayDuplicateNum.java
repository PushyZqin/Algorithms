package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author pushy zheng
 * @since 2019/8/8
 */
public class ArrayDuplicateNum {

    // 哈希集合实现，时间复杂度 O(n)， 空间复杂度 O(n)
//    public boolean duplicate(int[] numbers, int length, int[] duplication) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            if (set.contains(numbers[i])) {
//                duplication[0] = numbers[i];
//                return true;
//            }
//            set.add(numbers[i]);
//        }
//        return false;
//    }

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) return false;

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // swap
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayDuplicateNum s = new ArrayDuplicateNum();
        int[] res = new int[1];
        System.out.println(s.duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, res));
        System.out.println(res[0]);
    }

}

package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindNumbersWithSum {

    // 通过哈希表来实现
//    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
//        int min = Integer.MAX_VALUE;
//        ArrayList<Integer> res = new ArrayList<>();
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            map.put(array[i], i);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            int r = sum - array[i];
//            if (map.containsKey(r) && map.get(r) != i) {
//                if (r * array[i] < min) {
//                    min = r * array[i];
//                    res.add(Math.min(r, array[i]));
//                    res.add(Math.max(r, array[i]));
//                }
//            }
//        }
//        return res;
//    }

    // 通过双指针来实现
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0, end = array.length - 1;

        while (start < end) {
            int curSum = array[start] + array[end];
            if (curSum == sum) {
                res.add(array[start]);
                res.add(array[end]);
                return res;
            } else if (curSum < sum) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindNumbersWithSum s = new FindNumbersWithSum();
        System.out.println(s.FindNumbersWithSum(new int[]{1, 2, 3, 4, 5, 6}, 8));
    }

}

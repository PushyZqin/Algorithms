package offer;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int val = map.getOrDefault(num, 0);
            if (val + 1 > arr.length / 2) {
                return num;
            } else {
                map.put(num, val + 1);
            }
        }
        return 0;
    }

//    public int MoreThanHalfNum_Solution(int [] arr) {
//
//    }

    public static void main(String[] args) {
        MoreThanHalfNum s = new MoreThanHalfNum();
        System.out.println(s.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

}

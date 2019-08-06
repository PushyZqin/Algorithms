package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUglyNumber_Solution {

    // 遍历所有的数，判断是否为丑数，空间复杂度太高，会TLE
//    public int GetUglyNumber_Solution(int index) {
//        if (index < 7) return index;
//
//        int number = 0;
//        int uglyFound = 0;
//
//        while (uglyFound < index) {
//            ++number;
//            if (isUglyNumber(number)) {
//                ++uglyFound;
//            }
//        }
//        return number;
//    }
//
//    public boolean isUglyNumber(int num) {
//        if (num <= 0) {
//            return false;
//        }
//        while (num % 2 == 0) {  // 对2取余数，直到余数不为0
//            num = num / 2;
//        }
//        while (num % 3 == 0) {  // 对3取余数，直到余数不为0
//            num = num / 3;
//        }
//        while (num % 5 == 0) {  // 对5取余数，直到余数不为0
//            num = num / 5;
//        }
//        return num == 1;
//    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;

        // 该数组为里边为排好序的丑数，每一个丑数都是前面的丑数乘以2/3/5得到的数
        int[] arr = new int[index];
        arr[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;  // 2/3/5的丑数倍数

        for (int i = 1; i < index; ++i) {
            //  取2/3/5倍数的最小一个倍数
            arr[i] = Math.min(arr[t2] * 2, Math.min(arr[t3] * 3, arr[t5] * 5));
            if (arr[i] == arr[t2] * 2) t2++;
            if (arr[i] == arr[t3] * 3) t3++;
            if (arr[i] == arr[t5] * 5) t5++;
        }
        return arr[index - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution solution = new GetUglyNumber_Solution();
        System.out.println(solution.GetUglyNumber_Solution(10));
    }

}

package leetcode.problemset._658_Find_K_Closest_Elements;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/26 17:07
 */
public class Solution {

//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        LinkedList<Integer> res = new LinkedList<>();
//
//        int l = 0, r = arr.length - 1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (arr[mid] > x) r = mid - 1;
//            else if (arr[mid] < x) l = mid + 1;
//            else {
//                l = mid;
//                r = mid;
//                break;
//            }
//        }
//
//        int lt = 0, rt = 0;
//        int center = l;
//        k--;   // 去除它自己
//        while (l >= 0 || r < arr.length) {
//            if (l >= 1 && k > 0) {
//                lt++;
//                k--;
//            }
//            if (r < arr.length - 1 && k > 0) {
//                rt++;
//                k--;
//            }
//            l--;
//            r++;
//        }
//
//        int temp = center;
//        for (int i = 0; i < lt; i++) {
//            res.addFirst(arr[--temp]);
//        }
//        res.add(arr[center]);
//        temp = center;
//        for (int i = 0; i < rt; i++) {
//            res.add(arr[++temp]);
//        }
//
//        return res;
//    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0) return res;

        int l = 0, r = arr.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > x) r = mid;
            else if (arr[mid] < x) l = mid;
            else {
                l = mid;
                r = mid + 1;
            }
        }

        while (k > 0) {
            if (l < 0) {  // 当左边已经找完时
                r++;
            } else if (r >= arr.length) { // 当右边已经找完时
                l--;
            } else {
                if (arr[r] - x < x - arr[l]) {
                    r++;
                } else {
                    l--;
                }
            }
            k--;
        }
        for (int i = l + 1; i < r; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
        List<Integer> res = solution.findClosestElements(arr, 9, 4);

        System.out.println("res：" + res);
    }

}
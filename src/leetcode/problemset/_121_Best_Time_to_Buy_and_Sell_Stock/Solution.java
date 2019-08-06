package leetcode.problemset._121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/28 22:28
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int min = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[min]) min = i;
        }
        System.out.println(min);

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("res：" + res);
    }

}
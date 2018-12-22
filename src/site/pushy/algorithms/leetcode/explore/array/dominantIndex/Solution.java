package site.pushy.algorithms.leetcode.explore.array.dominantIndex;

/**
 * @author Pushy
 * @since 2018/111/10 14:23
 */
public class Solution {

    public int dominantIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (nums[i] < nums[j] * 2) {
                    break;
                }
            }
            return i;
        }
        
        
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.dominantIndex(new int[]{3, 6, 1, 0});

        System.out.println("result => " + result);
    }

}

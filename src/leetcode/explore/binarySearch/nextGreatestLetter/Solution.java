package site.pushy.algorithms.leetcode.explore.binarySearch.nextGreatestLetter;

/**
 * @author Pushy
 * @since 2019/1/21 15:18
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        if (target >= letters[r])
            return letters[0];

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return letters[l];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';

        Solution solution = new Solution();
        char res = solution.nextGreatestLetter(letters, target);
        System.out.println("res：" + res);
    }

}
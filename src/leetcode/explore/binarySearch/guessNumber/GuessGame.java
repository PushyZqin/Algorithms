package site.pushy.algorithms.leetcode.explore.binarySearch.guessNumber;

/**
 * @author Pushy
 * @since 2019/1/19 11:49
 */
public class GuessGame {

    private int guessNumber = 6;    // 从1~10选择的数

    int guess(int num) {
        return Integer.compare(guessNumber, num);
    }

}

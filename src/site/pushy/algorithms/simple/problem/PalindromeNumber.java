package site.pushy.algorithms.simple.problem;

/**
 * 一个5位数，判断它是不是回文数。
 * 如12321是回文数，个位与万位相同，十位与千位相同。
 *
 * @author Pushy
 * @since 2018/12/28 18:59
 */
public class PalindromeNumber {

    public static boolean solution(int num) {
        int length = getNumberLength(num);
        int[] nums = new int[length];

        /* 将整数拆分为个数按照个十百...的顺序存放到数组中 */
        for (int i = 0; i < length; i++) {
            nums[i] = num % 10;
            num /= 10;
        }

        /*int i = 0;
        do {
            nums[i] = num % 10;
            num /= 10;
            ++i;
        } while (num != 0);*/

        /* 比较数组，判断是不是回文数 */
        for (int j = 0; j < length / 2; j++) {
            if (nums[j] != nums[length - 1 - j]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取某个数的长度
     */
    private static int getNumberLength(int num) {
        return String.valueOf(num).length();
    }

    public static void main(String[] args) {
        boolean result = PalindromeNumber.solution(124521);
        System.out.println(result);
    }

}
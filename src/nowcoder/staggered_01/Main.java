package nowcoder.staggered_01;

import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/5/8 15:02
 * @question https://www.nowcoder.com/practice/3fbd8fe929ea4eb3a254c0ed34ac993a
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            int res = solution(str);
            System.out.println(res);
        }
    }

    /**
     * 双指针滑动窗口解决
     */
    private static int solution(String str) {
        int i = 1, j = 0;
        int max = Integer.MIN_VALUE;

        while (i < str.length()) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                max = Math.max(max, i - j);
                j = i;
                i++;
            } else {
                i++;
            }
        }
        max = Math.max(max, i - j);
        return max;
    }

    /**
     * 扫一遍记录每次交错子串的长度即可
     */
    private static int solution2(String str) {
        int max = Integer.MIN_VALUE, len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i + 1) != str.charAt(i)) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
            }
        }
        return max;
    }

}
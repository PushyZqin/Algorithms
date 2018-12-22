package site.pushy.algorithms.leetcode.explore.queueStack.solution.openLock;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2018/111/16 21:20
 */
public class Test {

    public static void main(String[] args) {

        String cur = "7777";

        char[] chars = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            for (int j : new int[]{-1, 1}) {
                char result = change(chars[i], j);
                System.out.println(result);
            }
        }
        System.out.println(chars);
    }

    private static char get(char c, int o) {
        if (o == -1) {
            String str = String.valueOf(Integer.parseInt(String.valueOf(c)) + 1);
            return str.charAt(0);
        } else {
            String str = String.valueOf((Integer.parseInt(String.valueOf(c)) - 1) % 10);
            return str.charAt(0);
        }
    }

    private static char change(char c, int i) {
        if (1 == i) {
            return c == '9' ? '0' : (char) (c + i);
        } else {
            return c == '0' ? '9' : (char) (c + i);
        }
    }

}

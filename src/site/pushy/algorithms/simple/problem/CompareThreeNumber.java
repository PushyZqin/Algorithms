package site.pushy.algorithms.simple.problem;

import java.util.Arrays;

/**
 * 输入3个数a,b,c，按大小顺序输出
 *
 * @author Pushy
 * @since 2018/12/28 19:58
 */
public class CompareThreeNumber {

    public static int[] solution(int a, int b, int c) {
        int[] res = new int[3];

        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        if (a > c) {
            int t = a;
            a = c;
            c = t;
        }

        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }

        res[0] = a;
        res[1] = b;
        res[2] = c;
        return res;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        int c = 5;

        int[] result = CompareThreeNumber.solution(a, b, c);
        System.out.println(Arrays.toString(result));
    }

}
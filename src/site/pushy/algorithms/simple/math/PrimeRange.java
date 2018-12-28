package site.pushy.algorithms.simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算0~200之间有多少个素数，并打印出素数的值
 */
public class PrimeRange {

    public static List<Integer> solution(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                /* 如果能被整除，则表明此数不是素数 */
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 200;

        List<Integer> res = PrimeRange.solution(n);
        System.out.println("1~" + n + "内所有的素数有： " + res);
    }
}

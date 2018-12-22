package site.pushy.algorithms.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算0~200之间有多少个素数，并打印出素数的值
 */
public class PrimeRange {

    public static void main(String[] args) {

        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i < 200; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                /* 如果能被整除，则表明此数不是素数 */
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeList.add(i);
            }
        }

        System.out.println("1~200 内所有的素数有： " + primeList);
    }
}

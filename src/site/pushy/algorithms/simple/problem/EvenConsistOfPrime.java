package site.pushy.algorithms.simple.problem;

import javafx.util.Pair;

/**
 * 一个偶数总能表示为两个素数之和
 *
 * @author Pushy
 * @since 2018/12/29 22:03
 */
public class EvenConsistOfPrime {

    public static Pair<Integer, Integer> solution(int n) {
        Pair<Integer, Integer> res = new Pair<>(-1, -1);

        for (int i = 0; i < n / 2 + 1; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                res = new Pair<>(i, n - i);
                break;
            }
        }

        return res;
    }

    private static boolean isPrime(int m) {
        boolean flag = true;
        for (int i = 2; i < Math.sqrt(m) + 1; i++) {
            if (m % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Pair<Integer, Integer> res = EvenConsistOfPrime.solution(8);

        System.out.println(res.getKey() + "，" + res.getValue());
    }

}
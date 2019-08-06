package simple.math;

import java.util.LinkedList;
import java.util.List;

/**
 * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。
 * 例如6=1＋2＋3.编程找出1000以内的所有完数。
 *
 * @author Pushy
 * @since 2018/12/27 17:54
 */
public class PerfectNumber {

    public static List<Integer> solution(int n) {
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0) {  // 如果余数为0，代表是该数的因子
                    sum += j;
                }
            }
            /* 判断因子的和是否与当前的数相等 */
            if (sum == i) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = PerfectNumber.solution(1000);
        System.out.println(result);
    }

}
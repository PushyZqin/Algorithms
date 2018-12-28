package site.pushy.algorithms.simple.math;

/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 *
 * @author Pushy
 * @since 2018/12/22 20:27
 */
public class PrimeFactorDecomposition {

    public static String solution(int num) {
        StringBuilder res = new StringBuilder();
        int i = 2;  // 定义最小质数

        while (i <= num) {
            /* 若num 能整除 i ，则i 是num 的一个因数 */
            if (num % i == 0) {
                res.append(i).append("*");
                num = num / i;
                i = 2;  // 将i重置为2
            } else {
                i++;
            }
        }
        return res.toString()
                .substring(0, res.toString().length() - 1);
    }

    public static String solution1(int num) {
        StringBuilder res = new StringBuilder();

        for (int i = 2; i < num + 1; i++) {
            while (num % i == 0 && num != i) {
                num /= i;
                res.append(i).append("*");
            }
            if (num == i) {
                break;
            }
        }
        return res.toString()
                .substring(0, res.toString().length() - 1);
    }

    public static void main(String[] args) {
        String result = PrimeFactorDecomposition.solution1(90);
        System.out.println(result);
    }
}

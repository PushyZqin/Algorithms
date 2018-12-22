package site.pushy.algorithms.simple.problem;

/**
 * 求1-n阶乘之和，例如3阶乘的和其实上就是2阶乘的和+3的阶乘
 *
 * @author Pushy
 * @since 2018/12/22 21:22
 */
public class FactorialSum {

    public static void solution(int n) {
        double sum = 0;  // 总和
        double factorial = 1;  // 记录每一个阶乘的总和
        for (int i = 1; i <= n; i++) {
            /*
                这里没有直接计算每一个n的阶乘，而是在n-1的阶乘数基础上做计算
                即 2 的阶乘为 factorial = 1 * 2
                而 3 的阶乘直接使用了 factorial = factorial * 3
             */
            factorial = factorial * i;
            sum = (int) (sum + factorial);
        }
        System.out.println("n - 1 阶乘的和为：" + sum);
    }

    public static void main(String[] args) {
        FactorialSum.solution(3);
    }

}

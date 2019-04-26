package site.pushy.algorithms.simple.math;

/**
 * 利用递归的方式求某个数的阶乘
 *
 * @author Pushy
 * @since 2018/12/28 13:23
 */
public class FiveFactorial {

    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        return solution(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = FiveFactorial.solution(3);
        System.out.println(result);
    }

}
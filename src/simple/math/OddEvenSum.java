package simple.math;

/**
 * 编写一个函数：
 * 当输入n为偶数时，调用函数求 1/2+1/4+...+1/n。
 * 当输入n为奇数时，调用函数 1/1+1/3+...+1/n (利用指针函数)
 *
 * @author Pushy
 * @since 2018/12/29 11:35
 */
public class OddEvenSum {

    /**
     * 需要注意的是必须使用double类型的数值，否则求出来的结果为0
     */
    public static double solution(int n) {
        if (n % 2 == 0) {
            return even(n);
        } else {
            return odd(n);
        }
    }

    private static double odd(int n) {
        double res = 0;
        for (int i = 1; i < n + 1; i += 2) {
            res += 1.0 / i;
        }
        return res;
    }

    private static double even(int n) {
        double res = 0;
        for (int i = 2; i < n + 1; i += 2) {
            res += 1.0 / i;
        }
        return res;
    }

    public static void main(String[] args) {
        double result = OddEvenSum.solution(7);
        System.out.println(result);
    }

}
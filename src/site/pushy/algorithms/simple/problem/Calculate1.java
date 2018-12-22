package site.pushy.algorithms.simple.problem;

/**
 * 求"1！+4！(2的平方)+9！(3的平方)+...+n的值
 *
 * @author Pushy
 * @since 2018/12/22 21:53
 */
public class Calculate1 {

    public static void solution(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int square = i * i;  // 平方数
            double factorial = 1;
            // 求阶乘
            for (int j = 1; j < square; j++) {
                factorial *= j;
            }
            sum += factorial;
        }

        System.out.println("总和为：" + sum);
    }

    public static void main(String[] args) {
        Calculate1.solution(2);
    }

}
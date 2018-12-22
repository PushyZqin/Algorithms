package site.pushy.algorithms.simple.problem;

/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 *
 * @author Pushy
 * @since 2018/12/22 20:27
 */
public class PrimeFactorDecomposition {

    public static void solution(int n) {
        for (int i = 2; i < n + 1; i++) {
            while (n % i == 0 && n != i) {
                n /= i;
                System.out.print(i + "*");
            }
            if (n == i) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        PrimeFactorDecomposition.solution(90);
    }
}

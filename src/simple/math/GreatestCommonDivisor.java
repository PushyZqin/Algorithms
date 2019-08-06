package simple.math;

/**
 * 求一个数的最大公约数
 *
 * 如果数a能被数b整除，a就叫做b的倍数，b就叫做a的约数。
 * 几个整数中公有的约数，叫做这几个数的公约数；其中最大的一个，叫做这几个数的最大公约数
 *
 * @author Pushy
 * @since 2018/12/25 17:56
 */
public class GreatestCommonDivisor {

    /**
     * 辗转相除法，通过循环来实现。辗转相除法：gcd(a, b) = gcd(b, a % b)
     */
    public static int solution(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {  // 数学上不考虑负数的约数
            return -1;
        }
        if (num2 == 0) {
            return num1;
        }
        while (num1 % num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num2;
    }

    public static int solution1(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {  // 数学上不考虑负数的约数
            return -1;
        }
        return euclidean(num2, num1 % num2);
    }

    /**
     * 辗转相除法，通过递归来实现。
     */
    public static int euclidean(int num1, int num2) {
        if (num2 == 0) {  // 如果余数为0，那么该除数就是最大公约数
            return num1;
        } else {
            return solution(num2, num1 % num2);
        }
    }


    public static void main(String[] args) {
        int a = 108;
        int b = 96;

        int result = GreatestCommonDivisor.solution1(a, b);
        System.out.println(result);
    }

}
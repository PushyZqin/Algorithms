package site.pushy.algorithms.simple.math;

/**
 * 判断一个数字是不是ugly number（分解出来的质因数只有2、3、5这3个数字）
 *
 * @author Pushy
 * @since 2018/12/23 22:02
 */
public class UglyNumber {

    /**
     * 如果一个数是Ugly Number，那么这个数不断除以2/3/5，最后得出来的还是1
     * 那么说明这个数就是由2/3/5组成的
     *
     * @param num
     * @return
     */
    public static boolean solution(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {  // 对2取余数，直到余数不为0
            num = num / 2;
        }

        while (num % 3 == 0) {  // 对3取余数，直到余数不为0
            num = num / 3;
        }

        while (num % 5 == 0) {  // 对5取余数，直到余数不为0
            num = num / 5;
        }

        return num == 1;
    }

    public static void main(String[] args) {
        boolean result = UglyNumber.solution(15);
        System.out.println(result);
    }

}
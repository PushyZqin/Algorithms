package site.pushy.algorithms.simple.math;

/**
 * 判断一个数是不是2的某次方
 *
 * @author Pushy
 * @since 2018/12/23 21:50
 */
public class PowerOfTwo {

    public static boolean solution(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {  // 2的0次方为1
            return true;
        }

        /* 除2取余数，直至余数不为0，看是不是等于1就可以判断是不是2的某次方了 */
        int m = 0;   // 记录几次方
        while (num % 2 == 0) {
            /* 当这个数可以整数2时，再对这个数进行赋值 => 除以 2。一直到无法整数2时 */
            num = num / 2;
            m += 1;
        }

        if (num == 1) {  // 如果是2的某次方，打印出次方的倍数
            System.out.println(m);
        }

        return num == 1;
    }

    public static void main(String[] args) {
        boolean result = PowerOfTwo.solution(8);

        System.out.println(result);
    }

}
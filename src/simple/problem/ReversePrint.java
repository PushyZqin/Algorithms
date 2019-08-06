package simple.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个不多于5位的正整数，
 * 要求：一、求它是几位数，二、逆序打印出各位数字。
 *
 * @author Pushy
 * @since 2018/12/28 14:25
 */
public class ReversePrint {

    /**
     * 通过操作字符串字符来处理
     *
     * @param num
     */
    public static void solution(int num) {
        int length;

        String str = String.valueOf(num);
        length = str.length();

        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(chars[str.length() - i - 1] + " ");
        }

        System.out.println();
        System.out.println("该数的长度为：" + length);
    }

    /**
     * 通过取余数的方式来处理，首先通过第10取余数，可以得到个位上的数
     * 然后将num/10，去掉个位上的数，将小数点向前移动一位
     *
     * @param num
     */
    public static void solution1(int num) {
        int i = 0;
        List<Integer> res = new ArrayList<>();

        do {
            res.add(num % 10);
            num /= 10;
            ++i;
        } while (num != 0);
        System.out.print("这是一个" + i + "位数，从个位起，各位数字依次为：");

        for (Integer n : res) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        ReversePrint.solution1(65458);
    }

}
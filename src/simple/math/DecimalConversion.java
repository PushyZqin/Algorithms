package simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pushy
 * @since 2019/4/7 19:37
 */
public class DecimalConversion {

    /**
     * 十进制转二进制
     * @param num
     */
    public static String decimalSystemToBinary(int num) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (num / 2 != 0) {
            list.add(num % 2);
            num /= 2;
        }
        list.add(num % 2);

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /**
     * 二进制转十进制
     * @param binary
     */
    public static int binaryToDecimalSystem(int binary) {
        String str = String.valueOf(binary);
        int sum = 0, len = str.length();

        for (int i = 0; i < len; i++) {
            int num = str.charAt(i) - '0';
            sum += (int) Math.pow(2, len - i - 1) * num;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(decimalToBinary(9));
        System.out.println(binaryToDecimalSystem(1011));
    }

}

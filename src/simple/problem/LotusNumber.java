package site.pushy.algorithms.simple.problem;

import site.pushy.algorithms.simple.CalculateRunTime;

import java.util.LinkedList;
import java.util.List;

/**
 * 打印出所有的三位水仙花数
 * <p>
 * 定义：所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方
 *
 * @author Pushy
 * @since 2018/12/22 19:37
 */
public class LotusNumber {

    private static List<Integer> lotusList = new LinkedList<>();

    /**
     * 最初的求法，通过操作字符串拿到个、十、百位上的数，这样的运行时间比较长
     */
    public void solution() {
        for (int i = 100; i < 999; i++) {  // 因为水仙花数必须是三位数，所以是从100~999
            String str = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j <= 2; j++) {
                int number = Integer.parseInt(str.substring(j, j + 1));
                sum += (number * number * number);
            }
            if (sum == i) {
                lotusList.add(i);
            }
        }
    }

    /**
     * 比较合适的求法，通过取余数的方式得到个、十、百位上的数
     */
    public void solution1() {
        for (int i = 100; i < 999; i++) {
            int ones = i % 10;  // 个位
            int tens = (i / 10) % 10; // 十位
            int hundreds = (i / 100) % 10; // 百位

            int cubicMetre = (ones * ones * ones) + (tens * tens * tens) + (hundreds * hundreds * hundreds);
            if (cubicMetre == i) {
                lotusList.add(i);
            }
        }
    }

    public static void main(String[] args) {
        CalculateRunTime.run(LotusNumber.class, "solution1");

        System.out.println("所有的水仙花数为： " + lotusList);
    }

}

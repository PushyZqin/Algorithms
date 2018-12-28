package site.pushy.algorithms.simple.math;

/**
 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 *
 * @author Pushy
 * @since 2018/12/28 11:05
 */
public class UnknownPerfectSquare {

    /**
     * 暴力求解
     * 在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方。
     * 如果开方后的结果满足如下条件，即是结果。
     */
    public static int solution() {
        for (int i = 0; i < 100000; i++) {
            int num1 = (int) Math.sqrt(i + 100);  // 必须要使用int类型的数据
            int num2 = (int) Math.sqrt(i + 100 + 168);

            if ((num1 * num1 == (i + 100)) && (num2 * num2 == (i + 268))) { // 符合条件的打印出来
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = UnknownPerfectSquare.solution();
        System.out.println(result);
    }

}
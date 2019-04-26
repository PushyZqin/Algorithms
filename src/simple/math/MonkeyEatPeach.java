package site.pushy.algorithms.simple.math;

/**
 * 题目：猴子摘下了n个桃子，当天吃掉一半多一个，第二天也是吃掉剩下桃子的一半多一个，
 * 到了第十天，桃子只剩下了1个。问：猴子第一天摘了多少个桃子
 * <p>
 * 分析：假设当天有n个桃子，它是前一天桃子的一半少一个，即：f(n-1) = f(n)/2 -1
 * 那么可得递归公式： f(n) = 2 * f(n-1) + 2
 *
 * @author Pushy
 * @since 2018/12/23 20:53
 */
public class MonkeyEatPeach {

    /**
     * 用递归的方式解决
     * @param x
     */
    public static int solution(int x) {
        if (x <= 0) {   // 天数无效
            return 0;
        }

        if (x == 1) {
            return 1;
        } else {
            return 2 * solution(x - 1) + 2;
        }
    }

    /**
     * 用循环的方式解决
     * @param day
     */
    public static int solution1(int day) {
        int x = 1;  // 最后一天的桃子个数
        for (int i = 1; i <= (day - 1); i++) {
            /* 一半多一个的逆向思维即： 两倍加1 */
            x = (x + 1) * 2;
        }
        return x;
    }

    public static void main(String[] args) {
        int result = MonkeyEatPeach.solution1(10);

        System.out.println(result);
    }

}
package site.pushy.algorithms.simple.math;

/**
 * 大数学家欧拉在集市上遇到了本村的两个农妇，每人跨着个空篮子。她们和欧拉打招呼说两人刚刚卖完了所有的鸡蛋。
 * 欧拉随便问：“卖了多少鸡蛋呢？”
 * 不料一个说：“我们两人自己卖自己的，一共卖了150个鸡蛋，虽然我们卖的鸡蛋有多有少，但刚好得了同样的钱数。你猜猜看！”
 * 欧拉猜不出。
 * 另一个补充道：“如果我按她那样的价格卖，可以得到32元；如果她按我的价格卖，可以得到24.5元”。
 * 欧拉想了想，说出了正确答案。
 * <p>
 * 求：这俩农夫究竟买了多少个鸡蛋
 *
 * @author Pushy
 * @since 2018/12/25 16:54
 */
public class SellEgg {

    /**
     * 解题思路：
     * 题中告诉我们两个农夫的价格一共买了150个鸡蛋，即 i + j = 150
     * 然后  x * p1 = y * p2 （俩农妇的卖的钱相等）
     * 并且 x * p2 = 32（A以B的价格卖能得32块）； y * p1 = 24.5（B以A的价格卖能得24.5块）
     */
    public static void solution() {
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                /* 暴力求解， i代表A卖的个数，j代表B卖的个数 */
                if (i + j == 150 && 24.5 * i * i == 32 * j * j) {
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        SellEgg.solution();
    }

}
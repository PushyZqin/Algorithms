package site.pushy.algorithms.simple.math;

/**
 * 啤酒每罐2.3元，饮料每罐1.9元。小明买了若干啤酒和饮料，一共花了82.3元。
 * 我们还知道他买的啤酒比饮料的数量少，请你计算他买了几罐啤酒。
 *
 * @author Pushy
 * @since 2018/12/25 16:46
 */
public class BeerDrink {

    /**
     * 通过暴力搜索法来解决
     * 如果82.3全部买啤酒可以买 32 瓶
     * 如果82.3全部买饮料可以买 43 瓶
     *
     * @return
     */
    public static int solution() {
        for (int i = 0; i < 36; i++) {
            for (int j = 0; j < 44; j++) {
                /* 满足题中的条件，i代表购买啤酒的数量，j代表购买饮料的数量 */
                if (2.3 * i + j * 1.9 == 82.3 && i < j) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int result = BeerDrink.solution();

        System.out.println(result);
    }

}
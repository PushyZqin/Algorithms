package site.pushy.algorithms.simple.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * 有1、2、3、4个数字，能组成多少个【互不相同】且【无重复数字】的三位数？都是多少？
 * <p>
 * 程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
 *
 * @author Pushy
 * @since 2018/12/28 10:52
 */
public class ThreeNumberCombination {

    public static List<Integer> solution() {
        List<Integer> res = new LinkedList<>();

        for (int i = 1; i < 5; i++) {  // 百
            for (int j = 1; j < 5; j++) {  // 十
                /* 如果百位和十位相等，则该数无效 */
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < 5; k++) {  // 个
                    /* 如果个位与十位或者与百位相等，则该数无效 */
                    if (k == j || k == i) {
                        continue;
                    }
                    int number = i * 100 + j * 10 + k;  // 计算出三位数
                    res.add(number);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = ThreeNumberCombination.solution();
        System.out.println(result);
    }

}
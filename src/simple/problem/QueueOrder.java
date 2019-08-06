package simple.problem;

/**
 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子。
 * 问最后留下的是原来第几号的那位。
 *
 * @author Pushy
 * @since 2018/12/29 11:10
 */
public class QueueOrder {

    public static int solution(int n) {
        /* 通过一个数组来维护每个人是否在的标志，以及最开始的位置 */
        boolean[] inArray = new boolean[n];
        int inCount = n;  // 目前还在的人数
        int index = 0;    // 每次循环的临时计数
        int counter = 0;  // 每局的计数器

        for (int i = 0; i < n; i++) {
            inArray[i] = true;
        }

        while (inCount > 1) {
            if (inArray[index]) {
                counter++;
                if (counter == 3) {
                    counter = 0;
                    inArray[index] = false;   // 代表退出
                    inCount--;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }

        // 找出还在的人
        for (int i = 0; i < n; i++) {
            if (inArray[i]) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int result = QueueOrder.solution(7);
        System.out.println(result);
    }

}
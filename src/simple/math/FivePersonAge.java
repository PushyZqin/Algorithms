package site.pushy.algorithms.simple.math;

/**
 * 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。
 * 问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。
 * 最后问第一个人，他说是10岁。请问第五个人多大？
 *
 * @author Pushy
 * @since 2018/12/28 14:08
 */
public class FivePersonAge {

    /**
     * 利用递归的方法，要想知道第五个人的岁数，需要知道第四个人的岁数。
     * 依次类推，推到第一个人10岁，然后在回推。
     * @param count
     * @param n
     * @return
     */
    public static int solution(int count, int n) {
        if (count == 1) {  // 递归的终止条件
            return 10;
        }
        return solution(count - 1, n) + n;
    }

    public static void main(String[] args) {
        int result = FivePersonAge.solution(5, 2);
        System.out.println(result);
    }

}
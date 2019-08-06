package nowcoder.independent_xiaoli;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/17 9:04
 * @question https://www.nowcoder.com/practice/a99cdf4e2f44499e80749699cc2ec2b9
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt(), f = sc.nextInt();
            int d = sc.nextInt(), p = sc.nextInt();

            int res = solution(x, f, d, p);
            System.out.println(res);
        }
    }

    /*private static int solution(int x, int f, int d, int p) {
        int res = 0;

        if (x > d) return res;

        while (f > 0 && d > 0) {
            d -= x;
            f--;
            res++;
        }

        if (d <= 0) return res;

        while (d > p + x) {
            d -= (p + x);
            res++;
        }

        return res;
    }*/

    private static int solution(int x, int f, int d, int p) {
        if (x > d) return 0;  // 带的钱交不起房租

        if (d - (x * f) > 0) {  // 在苹果吃完之后还有剩余的钱
            int m = d - (x * f);
            return f + m / (p + x);
        } else {  // 苹果没吃完之前就没钱了
            return d / x;
        }
    }

}
package nowcoder.niuniu_bag;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/8/1 22:51
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), w = sc.nextInt();
            int[] arr = new int[n];
            int idx = 0;

            while (n-- > 0) {
                arr[idx++] = sc.nextInt();
            }

            int res = solution(arr, w);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr, int w) {


        return 0;
    }
}
package nowcoder.interval_express;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/17 20:37
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int res = solution(arr);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                res++;
            }
        }
        return res;
    }

}
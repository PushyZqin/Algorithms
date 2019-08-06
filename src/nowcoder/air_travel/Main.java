package nowcoder.air_travel;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/17 10:02
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), s = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int res = solution(arr, s);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr, int s) {
        int res = 0;
        int idx = 0;

        while (idx < arr.length && s >= arr[idx]) {
            s -= arr[idx];
            idx++;
            res++;
        }

        return res;
    }

}
package nowcoder.digital_game;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/18 9:16
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

            int res = solution(arr, n);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String str = String.valueOf(arr[i]);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            max = Math.max(max, Integer.parseInt(new String(chars)));
        }

        return max;
    }

}
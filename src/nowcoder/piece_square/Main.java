package nowcoder.piece_square;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/17 20:28
 * @question https://www.nowcoder.com/practice/563c6a69fd714e59a942d97047cedcb3
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

            int res = solution(a, b, c, d);
            System.out.println(res);
        }
    }

    private static int solution(int a, int b, int c, int d) {
        int[] arr = new int[]{a, b, c, d};
        Arrays.sort(arr);

        int mid = arr[2];

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += Math.abs(arr[i] - mid);
        }

        return res;
    }

}
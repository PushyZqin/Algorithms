package nowcoder.piece_triangle;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/18 19:27
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            int res = solution(arr);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);

        int a = arr[0], b = arr[1], c = arr[2];

        if (a == c && b == c) return a + b + c;  // 等边三角形

        while (b + a <= c) {
            c--;
        }
        return a + b + c;
    }

}
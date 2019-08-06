package nowcoder.sequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            String res = solution(arr);
            System.out.println(res);
        }
    }

    private static String solution(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];  // 公差
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] + d != arr[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }

}
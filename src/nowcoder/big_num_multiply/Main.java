package nowcoder.big_num_multiply;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            String num1 = strs[0], num2 = strs[1];

            String res = solution(num1, num2);
            System.out.println(res);
        }
    }

    private static String solution(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] arr = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int number1 = num1.charAt(i) - '0';
                int number2 = num2.charAt(j) - '0';
                arr[i + j] += number1 * number2;
                if (arr[i + j] >= 10 && (i + j) != 0) {
                    arr[i + j - 1] += arr[i + j] / 10;
                    arr[i + j] = arr[i + j] % 10;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= arr.length - 2; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }

}
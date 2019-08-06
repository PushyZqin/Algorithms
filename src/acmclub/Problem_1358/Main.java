package acmclub.Problem_1358;

import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/4/27 17:09
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            int res = solution(a, b);
        }
    }

    public static int solution(int a, int b) {
        return -1;
    }


}

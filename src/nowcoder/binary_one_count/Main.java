package nowcoder.binary_one_count;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int num = Integer.parseInt(line);

            int res = solution(num);
            System.out.println(res);
        }
    }

    private static int solution(int num) {
        int cnt = 0;
        while (num > 0) {
            int r = num % 2;
            if (r == 1) cnt++;
            num /= 2;
        }
        return cnt;
    }

}
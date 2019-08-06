package nowcoder.maze_find_way;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            int M = Integer.parseInt(strs[0]), N = Integer.parseInt(strs[1]);

            char[][] matrix = new char[M][N];
            for (int i = 0; i < M; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }

            int res = solution(matrix);
            System.out.println(res);
        }
    }

    private static int solution(char[][] matrix) {
        // Todo maze find way
        // find start position


        return 0;
    }

}